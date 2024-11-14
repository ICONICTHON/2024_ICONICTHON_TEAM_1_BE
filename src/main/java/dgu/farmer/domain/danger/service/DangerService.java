package dgu.farmer.domain.danger.service;

import dgu.farmer.domain.danger.dto.DangerRequestDto;
import dgu.farmer.domain.danger.dto.DangerResponseDto;
import dgu.farmer.domain.danger.entity.Danger;
import dgu.farmer.domain.danger.repository.DangerRepository;
import dgu.farmer.domain.member.repository.MemberRepository;
import dgu.farmer.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DangerService {
    private final DangerRepository dangerRepository;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<DangerResponseDto> getAllDangers() {
        return dangerRepository.findAll().stream()
                .map(danger -> new DangerResponseDto(danger.getDangerId(), danger.getBuildingName(),
                        danger.getLatitude(), danger.getLongitude(), danger.getContent(), danger.getImageUrl(), danger.getReportTime()))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long createDanger(DangerRequestDto requestDto, Long memberId) {
        Danger danger = Danger.builder()
                .buildingName(requestDto.getBuildingName())
                .content(requestDto.getContent())
                .imageUrl(requestDto.getImageUrl())
                .latitude(requestDto.getLatitude())
                .longitude(requestDto.getLongitude())
                .reportTime(requestDto.getReportTime())
                .build();
        dangerRepository.save(danger);

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        member.updatePoints(300);
        memberRepository.save(member);

        return danger.getDangerId();
    }

    @Transactional
    public DangerResponseDto getDangerById(Long dangerId) {
        Danger danger = dangerRepository.findById(dangerId)
                .orElseThrow(() -> new RuntimeException("Danger not found"));
        return DangerResponseDto.builder()
                .dangerId(danger.getDangerId())
                .buildingName(danger.getBuildingName())
                .longitude(danger.getLongitude())
                .latitude(danger.getLatitude())
                .content(danger.getContent())
                .imageUrl(danger.getImageUrl())
                .reportTime(danger.getReportTime())
                .build();
    }
}
