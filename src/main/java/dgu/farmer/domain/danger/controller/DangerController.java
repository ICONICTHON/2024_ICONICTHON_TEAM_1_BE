package dgu.farmer.domain.danger.controller;

import dgu.farmer.domain.danger.dto.DangerRequestDto;
import dgu.farmer.domain.danger.dto.DangerResponseDto;
import dgu.farmer.domain.danger.service.DangerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Danger API", description = "위험 요소 관리 API")
@RestController
@RequestMapping("/api/danger")
@RequiredArgsConstructor
public class DangerController {
    private final DangerService dangerService;

    @Operation(summary = "Get all dangers", description = "전체 위험 요소 목록을 가져옵니다.")
    @GetMapping
    public ResponseEntity<List<DangerResponseDto>> getAllDangers() {
        return ResponseEntity.ok(dangerService.getAllDangers());
    }

    @Operation(summary = "Create danger", description = "새로운 위험 요소를 생성합니다.")
    @PostMapping("/{memberId}")
    public ResponseEntity<Long> createDanger(
            @Parameter(description = "위험 요소 생성 요청 정보", required = true) @RequestBody DangerRequestDto requestDto,
            @Parameter(description = "회원 ID", required = true) @PathVariable Long memberId) {
        Long dangerId = dangerService.createDanger(requestDto, memberId);
        return ResponseEntity.ok(dangerId);
    }

    @Operation(summary = "Get danger by ID", description = "특정 위험 요소의 상세 정보를 가져옵니다.")
    @GetMapping("/detail/{dangerId}")
    public ResponseEntity<DangerResponseDto> getDangerById(
            @Parameter(description = "위험 요소 ID", required = true) @PathVariable Long dangerId) {
        return ResponseEntity.ok(dangerService.getDangerById(dangerId));
    }

}
