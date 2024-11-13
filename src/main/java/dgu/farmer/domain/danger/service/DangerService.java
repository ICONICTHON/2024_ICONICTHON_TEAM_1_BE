package dgu.farmer.domain.danger.service;

import dgu.farmer.domain.danger.dto.DangerRequestDto;
import dgu.farmer.domain.danger.dto.DangerResponseDto;
import dgu.farmer.domain.danger.entity.Danger;
import dgu.farmer.domain.danger.repository.DangerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DangerService {
    private final DangerRepository dangerRepository;

    @Transactional(readOnly = true)
    public List<DangerResponseDto> getAllDangers() {
        return dangerRepository.findAll().stream()
                .map(danger -> new DangerResponseDto(danger.getBuildingName(),
                        danger.getLatitude(), danger.getLongitude()))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long createDanger(DangerRequestDto requestDto) {
        Danger danger = Danger.builder()
                .buildingName(requestDto.getBuildingName())
                .content(requestDto.getContent())
                .imageUrl(requestDto.getImageUrl())
                .latitude(requestDto.getLatitude())
                .longitude(requestDto.getLongitude())
                .reportTime(requestDto.getReportTime())
                .build();
        dangerRepository.save(danger);
        return danger.getDangerId();
    }
}
