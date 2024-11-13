package dgu.farmer.domain.location.service;

import dgu.farmer.domain.danger.repository.DangerRepository;
import dgu.farmer.domain.location.converter.HomeConverter;
import dgu.farmer.domain.location.dto.HomeDTO.Response.HomeResponse;
import dgu.farmer.domain.location.dto.HomeDTO.Response.LocationInfo;
import dgu.farmer.domain.location.dto.HomeDTO.Response.DangerInfo;
import dgu.farmer.domain.location.repository.LocationRepository;
import dgu.farmer.domain.member.entity.Member;
import dgu.farmer.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HomeServiceImpl implements HomeService {

    private final LocationRepository locationRepository;
    private final DangerRepository dangerRepository;
    private final MemberRepository memberRepository;
    public HomeResponse getInfo(Long memberId) {
        // 사용자 정보 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 위치 상태 정보 조회 및 변환
        List<LocationInfo> locations = locationRepository.findAll().stream()
                .map(HomeConverter::toLocationInfo)
                .toList();

        // 모든 위험 구역 정보 조회 및 변환
        List<DangerInfo> dangers = dangerRepository.findAll().stream()
                .map(HomeConverter::toDangerInfo)
                .toList();

        // 응답 생성
        return HomeResponse.builder()
                .locations(locations)
                .dangers(dangers)
                .points(member.getPoints())
                .memberName(member.getMemberName())
                .build();
    }
}
