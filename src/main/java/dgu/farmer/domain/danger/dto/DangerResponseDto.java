package dgu.farmer.domain.danger.dto;

import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DangerResponseDto {
    private Long dangerId;
    private String buildingName;
    private Double latitude;
    private Double longitude;
    private String content;
    private String imageUrl;
    private LocalDateTime reportTime;
}

