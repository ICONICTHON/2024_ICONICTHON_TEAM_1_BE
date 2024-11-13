package dgu.farmer.domain.location.controller;

import dgu.farmer.domain.location.dto.HomeDTO.Response.HomeResponse;
import dgu.farmer.domain.location.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/home")
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/{memberId}")
    public ResponseEntity<HomeResponse> getUserInfo(
            @PathVariable Long memberId) {
        return ResponseEntity.ok(homeService.getInfo(memberId));
    }


}
