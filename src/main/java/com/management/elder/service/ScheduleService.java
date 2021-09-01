package com.management.elder.service;

import com.management.elder.elements.*;
import com.management.elder.elements.Schedule;
import com.management.elder.elements.ScheduleContentRequestDto;
import com.management.elder.elements.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service // 서비스임을 선언합니다.
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    /*@Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long update(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        schedule.update(requestDto);
        return id;
    }*/

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long update(Long id, ScheduleContentRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        schedule.update(requestDto);
        return id;
    }
}