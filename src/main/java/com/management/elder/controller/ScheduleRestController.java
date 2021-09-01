package com.management.elder.controller;


import com.management.elder.elements.*;
import com.management.elder.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ScheduleRestController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // 스케줄 조회
    //scheduleNo
    @GetMapping("/api/schedules")
    public List<Schedule> getSchedule(@RequestParam("id") Long id) {
        return scheduleRepository.findAllByScheduleUser_UserNo(id);
    }
    //id = scheduleId(로그인시 사용했던 아이디)
    /*public Schedule getSchedule(@RequestParam("id") String id) {
        return scheduleRepository.findByScheduleIdEquals(id);
    }*/

    // 스케줄 작성
    @PostMapping("/api/schedules/{id}")
    public Schedule createSchedule(@PathVariable Long id,@RequestBody ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);
        schedule.setScheduleUser(userRepository.findByUserNoEquals(id));
        scheduleRepository.save(schedule);
        return schedule;
    }

    /*// 사용자 정보 변경
    @PutMapping("/api/schedules")
    public Long updateSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Long id=requestDto.getScheduleNo();
        return scheduleService.update(id, requestDto);
    }*/

    // 스케줄 수정
    @PutMapping("/api/schedules/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody ScheduleContentRequestDto requestDto) {
        return scheduleService.update(id, requestDto);
    }

    //스케줄 삭제
    @DeleteMapping("/api/schedules/{id}")
    public Long deleteSchedule(@PathVariable Long id) {
        scheduleRepository.deleteById(id);
        return id;
    }

}

