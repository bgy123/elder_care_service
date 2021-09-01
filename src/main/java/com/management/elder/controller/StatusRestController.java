package com.management.elder.controller;

import com.management.elder.elements.Status;
import com.management.elder.elements.StatusRepository;
import com.management.elder.elements.StatusRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class StatusRestController {

    //private final StatusService statusService;
    private final StatusRepository statusRepository;


    // 데이터 조회
    //id = 독거노인 식별자
    @GetMapping("/api/status")
    public Optional<Status> getStatus(@RequestParam("id") Long id) {
        return statusRepository.findAllByStatusOldNoEquals(id);
    }

    //id = statusId(로그인시 사용했던 아이디)
    /*public Status getStatus(@RequestParam("id") String id) {
        return statusRepository.findByStatusIdEquals(id);
    }*/

    // 새 사용자 등록
    @PostMapping("/api/status")
    public Status createStatus(@RequestBody StatusRequestDto requestDto) {
        Status status = new Status(requestDto);
        statusRepository.save(status);
        return status;
    }

    /*// 사용자 정보 변경
    @PutMapping("/api/status")
    public Long updateStatus(@RequestBody StatusRequestDto requestDto) {
        //id를 식별자로 변경해서 식별자로 테이블 접근하는 함수 생성 ex)테이블 리스트로 불러와서 조건문으로 확인
        Long id=requestDto.getStatusNo();
        return statusService.update(id, requestDto);
    }*/

    @DeleteMapping("/api/status/{id}")
    public Long deleteStatus(@PathVariable Long id) {
        statusRepository.deleteById(id);
        return id;
    }

}

