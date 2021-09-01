package com.management.elder.controller;


import com.management.elder.elements.Visit;
import com.management.elder.elements.VisitContentRequestDto;
import com.management.elder.elements.VisitRepository;
import com.management.elder.elements.VisitRequestDto;
import com.management.elder.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class VisitRestController {

    private final VisitService visitService;
    private final VisitRepository visitRepository;

    // 사용자 정보 조회
    //visitNo
    @GetMapping("/api/visits")
    public List<Visit> getVisit(@RequestParam("id") Long id) {
        return visitRepository.findAllByVisitOldNo(id);
    }
    //id = visitId(로그인시 사용했던 아이디)
    /*public Visit getVisit(@RequestParam("id") String id) {
        return visitRepository.findByVisitIdEquals(id);
    }*/

    // 새 방문일지 등록
    @PostMapping("/api/visits")
    public Visit createVisit(@RequestBody VisitRequestDto requestDto) {
        Visit visit = new Visit(requestDto);
        visitRepository.save(visit);
        return visit;
    }

    /*// 사용자 정보 변경
    @PutMapping("/api/visits")
    public Long updateVisit(@RequestBody VisitRequestDto requestDto) {
        Long id=requestDto.getVisitNo();
        return visitService.update(id, requestDto);
    }*/

    // 방문일지 변경
    @PutMapping("/api/visits/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody VisitContentRequestDto requestDto) {
        return visitService.update(id, requestDto);
    }

    //방문일지 삭제
    @DeleteMapping("/api/visits/{id}")
    public Long deleteVisit(@PathVariable Long id) {
        visitRepository.deleteById(id);
        return id;
    }

}

