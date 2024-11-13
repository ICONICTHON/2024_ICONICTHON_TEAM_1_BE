package dgu.farmer.domain.danger.controller;

import dgu.farmer.domain.danger.dto.DangerRequestDto;
import dgu.farmer.domain.danger.dto.DangerResponseDto;
import dgu.farmer.domain.danger.service.DangerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/danger")
@RequiredArgsConstructor
public class DangerController {
    private final DangerService dangerService;

    @GetMapping
    public ResponseEntity<List<DangerResponseDto>> getAllDangers() {
        return ResponseEntity.ok(dangerService.getAllDangers());
    }

    @PostMapping
    public ResponseEntity<Long> createDanger(@RequestBody DangerRequestDto requestDto) {
        Long dangerId = dangerService.createDanger(requestDto);
        return ResponseEntity.ok(dangerId);
    }
}
