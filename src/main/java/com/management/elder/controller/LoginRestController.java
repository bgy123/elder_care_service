package com.management.elder.controller;

import com.management.elder.elements.LoginDto;
import com.management.elder.elements.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController // JSON으로 응답함을 선언합니다.
public class LoginRestController {

    private final UserRepository userRepository;

    //테이블에 입력 받은 아이디 비밀번호와 같은 값이 존재하면 true 반환
    /*@GetMapping("/api/logins")
    public boolean getLogin(@RequestParam("id") String id,@RequestParam("pw") String pw) {
        if(userRepository.findByUserIdEqualsAndUserPw(id,pw)!=null) {
            return true;
        }
        else
            return false;

    }*/
    @PostMapping("/api/logins")
    public boolean getLogin(@RequestBody LoginDto requestDto) {
        if(userRepository.findByUserIdEqualsAndUserPw(requestDto.getUserId(), requestDto.getUserPw())!=null) {
            return true;
        }
        else
            return false;
    }
}