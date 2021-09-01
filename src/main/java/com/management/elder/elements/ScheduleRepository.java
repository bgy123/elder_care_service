package com.management.elder.elements;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
   // User findByScheduleUserNo(Long id);
   List<Schedule> findAllByScheduleUser_UserNo(Long id);
}
