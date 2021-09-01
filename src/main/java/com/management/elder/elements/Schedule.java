package com.management.elder.elements;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Setter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "schedule")
public class Schedule extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long scheduleNo;

    /*// 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private Long scheduleUserNo;*/

    //@Column(nullable = false)
    private String scheduleContent;

    @Column(nullable = false)
    private LocalDate scheduleDate;

    @ManyToOne
    @JoinColumn(name = "schedule_user_no")
    private User scheduleUser;

    // 관심 상품 생성 시 이용합니다.
    public Schedule(ScheduleRequestDto requestDto) {
        //this.scheduleNo = requestDto.getScheduleNo();
        //this.scheduleUserNo = requestDto.getScheduleUserNo();
        this.scheduleContent = requestDto.getScheduleContent();
        this.scheduleDate = LocalDate.now();
    }

    /*public void updateByItemDto(ItemDto itemDto){
        this.lprice=itemDto.getLprice();
    }*/

    // 내용 수정
    public void update(ScheduleContentRequestDto requestDto) {
        this.scheduleContent = requestDto.getScheduleContent();
    }
}