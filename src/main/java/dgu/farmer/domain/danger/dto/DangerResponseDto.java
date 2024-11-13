package dgu.farmer.domain.danger.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DangerResponseDto {
    private String buildingName;
    private Double latitude;
    private Double longitude;
}

