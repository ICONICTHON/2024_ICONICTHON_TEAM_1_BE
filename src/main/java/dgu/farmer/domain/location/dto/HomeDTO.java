package dgu.farmer.domain.location.dto;

import dgu.farmer.domain.location.entity.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class HomeDTO {
    public static class Response {
        @Builder
        @Getter
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        @AllArgsConstructor(access = AccessLevel.PROTECTED)
        public static class HomeResponse {
            private List<LocationInfo> locations;
            private List<DangerInfo> dangers;
            private Integer points;
            private String memberName;
        }

        @Getter
        @Builder
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        @AllArgsConstructor
        public static class LocationInfo {
            private Long locationId;
            private String buildingName;
            private Status status;
            private LocalDateTime updatedTime;
        }

        @Getter
        @Builder
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        @AllArgsConstructor
        public static class DangerInfo {
            private Long dangerId;
            private String buildingName;
            private String content;
            private LocalDateTime reportTime;
        }
    }
}
