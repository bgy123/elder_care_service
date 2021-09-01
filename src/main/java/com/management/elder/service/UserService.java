package com.management.elder.service;

import com.management.elder.elements.User;
import com.management.elder.elements.UserMemoDto;
import com.management.elder.elements.UserRepository;
import com.management.elder.elements.UserRequestDto;
import com.management.elder.elements.UserMemoDto;
import com.management.elder.elements.UserRepository;
import com.management.elder.elements.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service // 서비스임을 선언합니다.
public class UserService {

    private final UserRepository userRepository;

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long update(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        user.update(requestDto);
        return id;
    }

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long updateMemo(Long id, UserMemoDto memoDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        user.updateMemo(memoDto);
        return id;
    }
}