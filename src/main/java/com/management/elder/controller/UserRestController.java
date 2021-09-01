package com.management.elder.controller;

import com.management.elder.elements.User;
import com.management.elder.elements.UserMemoDto;
import com.management.elder.elements.UserRepository;
import com.management.elder.elements.UserRequestDto;
import com.management.elder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class UserRestController {

    private final UserService userService;
    private final UserRepository userRepository;

    // 사용자 정보 조회
    //userNo로 조회
    @GetMapping("/api/users")
    public Optional<User> getUser(@RequestParam("id") Long id) {
        return userRepository.findById(id);
    }
    //id = userId(로그인시 사용했던 아이디)
    /*public User getUser(@RequestParam("id") String id) {
        return userRepository.findByUserIdEquals(id);
    }*/

    // 새 사용자 등록
    @PostMapping("/api/users")
    public User createUser(@RequestBody UserRequestDto requestDto) {
        User user = new User(requestDto);
        userRepository.save(user);
        return user;
    }

    // 사용자 정보 변경
    @PutMapping("/api/users")
    public Long updateUser(@RequestBody UserRequestDto requestDto) {
        Long id=requestDto.getUserNo();
        return userService.update(id, requestDto);
    }

    // 메모 변경
    @PutMapping("/api/users/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody UserMemoDto requestDto) {
        return userService.updateMemo(id, requestDto);
    }

    //사용자 삭제
    @DeleteMapping("/api/users/{id}")
    public Long deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return id;
    }

}

