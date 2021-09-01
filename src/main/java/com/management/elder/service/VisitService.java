package com.management.elder.service;

import com.management.elder.elements.Visit;
import com.management.elder.elements.VisitContentRequestDto;
import com.management.elder.elements.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service // 서비스임을 선언합니다.
public class VisitService {

    private final VisitRepository visitRepository;

    /*@Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long update(Long id, VisitRequestDto requestDto) {
        Visit visit = visitRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        visit.update(requestDto);
        return id;
    }*/

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long update(Long id, VisitContentRequestDto requestDto) {
        Visit visit = visitRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        visit.update(requestDto);
        return id;
    }
}