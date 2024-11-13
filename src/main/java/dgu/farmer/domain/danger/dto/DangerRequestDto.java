package dgu.farmer.domain.danger.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DangerRequestDto {
    private String buildingName;
    private String content;
    private String imageUrl;
    private Double latitude;
    private Double longitude;
    private LocalDateTime reportTime;
}
