package dgu.farmer.domain.location.controller;

import dgu.farmer.domain.location.dto.HomeDTO.Response.HomeResponse;
import dgu.farmer.domain.location.service.HomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Home API", description = "사용자 홈 정보 관리 API")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/home")
public class HomeController {

    private final HomeService homeService;

    @Operation(summary = "Get user information", description = "특정 회원의 홈 정보를 가져옵니다.")
    @GetMapping("/{memberId}")
    public ResponseEntity<HomeResponse> getUserInfo(
            @Parameter(description = "회원 ID", required = true) @PathVariable Long memberId) {
        return ResponseEntity.ok(homeService.getInfo(memberId));
    }
}
