package com.management.elder.controller;

import com.management.elder.elements.Data;
import com.management.elder.elements.DataRepository;
import com.management.elder.elements.DataRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class DataRestController {

    //private final DataService dataService;
    private final DataRepository dataRepository;


    // 데이터 조회
    //id = 독거노인 식별자
    @GetMapping("/api/data")
    public Optional<Data> getData(@RequestParam("id") Long id) {
        return dataRepository.findAllByDataOldNoEquals(id);
    }

    //id = dataId(로그인시 사용했던 아이디)
    /*public Data getData(@RequestParam("id") String id) {
        return dataRepository.findByDataIdEquals(id);
    }*/

    // 데이터 등록
    @PostMapping("/api/data")
    public Data createData(@RequestBody DataRequestDto requestDto) {
        Data data = new Data(requestDto);
        dataRepository.save(data);
        return data;
    }

    /*// 사용자 정보 변경
    @PutMapping("/api/data")
    public Long updateData(@RequestBody DataRequestDto requestDto) {
        //id를 식별자로 변경해서 식별자로 테이블 접근하는 함수 생성 ex)테이블 리스트로 불러와서 조건문으로 확인
        Long id=requestDto.getDataNo();
        return dataService.update(id, requestDto);
    }*/

    @DeleteMapping("/api/data/{id}")
    public Long deleteData(@PathVariable Long id) {
        dataRepository.deleteById(id);
        return id;
    }

}

