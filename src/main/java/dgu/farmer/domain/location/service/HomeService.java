package dgu.farmer.domain.location.service;

import dgu.farmer.domain.location.dto.HomeDTO.Response.HomeResponse;

public interface HomeService {
    HomeResponse getInfo(Long memberId);
}
