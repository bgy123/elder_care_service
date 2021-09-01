package com.management.elder.controller;

import com.management.elder.elements.*;
import com.management.elder.service.OldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class OldRestController {

    private final OldService oldService;
    private final OldRepository oldRepository;
    private final UserRepository userRepository;


    // 독거노인 정보 조회
    @GetMapping("/api/olds")
    public List<Old> getOld(@RequestParam("id") Long userNo,
                            @RequestParam(required = false) String region,
                            @RequestParam(required = false) Boolean gender,
                            @RequestParam(required = false) String name) {
        /*if (region != null) {
        }*/
        if (region != null && gender != null && name != null) {
            return oldRepository.findAllByOldUser_UserNoAndOldRegionAndOldGenderAndOldNameEquals(
                    userNo, region, gender, name);
        }

        //if (region == null && gender == null && name == null)
            return oldRepository.findAllByOldUser_UserNo(userNo);

    }

    // 독거노인 등록
    @PostMapping("/api/olds/{id}")
    public Old createOld(@PathVariable Long id,@RequestBody OldRequestDto requestDto) {
        Old old = new Old(requestDto);
        old.setOldUser(userRepository.findByUserNoEquals(id));
        oldRepository.save(old);
        return old;
    }

    // 독거노인 정보 변경
    @PutMapping("/api/olds")
    public Long updateOld(@RequestBody OldRequestDto requestDto) {
        //id를 식별자로 변경해서 식별자로 테이블 접근하는 함수 생성 ex)테이블 리스트로 불러와서 조건문으로 확인
        Long oldNo = requestDto.getOldNo();//이렇게 하려면 입력 받아야 함
        return oldService.update(oldNo, requestDto);
    }

    @DeleteMapping("/api/olds/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        oldRepository.deleteById(id);
        return id;
    }

}

