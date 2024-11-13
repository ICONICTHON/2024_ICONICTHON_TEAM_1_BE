package dgu.farmer.domain.location.converter;

import dgu.farmer.domain.danger.entity.Danger;
import dgu.farmer.domain.location.dto.HomeDTO.Response.DangerInfo;
import dgu.farmer.domain.location.dto.HomeDTO.Response.LocationInfo;
import dgu.farmer.domain.location.entity.Location;

public class HomeConverter {
    public static LocationInfo toLocationInfo(Location location) {
        return LocationInfo.builder()
                .locationId(location.getLocationId())
                .buildingName(location.getBuildingName())
                .status(location.getStatus())
                .updatedTime(location.getUpdatedTime())
                .build();
    }

    public static DangerInfo toDangerInfo(Danger danger) {
        return DangerInfo.builder()
                .dangerId(danger.getDangerId())
                .buildingName(danger.getBuildingName())
                .content(danger.getContent())
                .reportTime(danger.getReportTime())
                .build();
    }
}
