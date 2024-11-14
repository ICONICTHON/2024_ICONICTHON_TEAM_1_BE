package dgu.farmer.domain.s3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/{prefix}/presigned-url")
    public ResponseEntity<String> getPresignedUrl(@PathVariable String prefix, @RequestBody FileDTO fileDTO) {
        String fileName = fileDTO.getImageName();
        String presignedUrl = fileService.getPreSignedUrl(prefix, fileName);
        return ResponseEntity.ok(presignedUrl);
    }
}
