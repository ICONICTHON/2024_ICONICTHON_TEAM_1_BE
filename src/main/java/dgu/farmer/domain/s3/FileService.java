package dgu.farmer.domain.s3;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    public String getPreSignedUrl(String prefix, String originalFileName) {
        String fileName = sanitizeFileName(originalFileName);
        String path = createPath(prefix, fileName);

        return generatePreSignedUrl(path).toString();
    }

    private URL generatePreSignedUrl(String filePath) {
        Date expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 2); // 2 minutes
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucket, filePath)
                .withMethod(HttpMethod.PUT)
                .withExpiration(expiration);

        return amazonS3.generatePresignedUrl(request);
    }

    private String sanitizeFileName(String fileName) {
        // 파일명에서 비허용 문자 제거, 필요 시 확장자 검증 추가
        return fileName.replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
    }

    private String createPath(String prefix, String fileName) {
        return String.format("%s/%s-%s", prefix, UUID.randomUUID().toString(), fileName);
    }
}