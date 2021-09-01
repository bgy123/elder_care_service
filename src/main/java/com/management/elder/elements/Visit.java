package com.management.elder.elements;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//방문일지
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "visit")
public class Visit extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long visitNo;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private Long visitOldNo;

    //@Column(nullable = false)
    private Boolean visitBookmark;

   //@Column(nullable = false)
    private String visitContent;

    @Column(nullable = false)
    private LocalDate visitDate;

    /*@ManyToOne
    @JoinColumn(name = "visit_old_no")
    private Old visitOld;*/

    // 관심 상품 생성 시 이용합니다.
    public Visit(VisitRequestDto requestDto) {
        this.visitNo=requestDto.getVisitNo();
        this.visitOldNo=requestDto.getVisitOldNo();
        this.visitBookmark=requestDto.getVisitBookmark();
        this.visitContent=requestDto.getVisitContent();
        this.visitDate=requestDto.getVisitDate();
    }

    /*public void updateByItemDto(ItemDto itemDto){
        this.lprice=itemDto.getLprice();
    }*/

    // 내용 수정
    public void update(VisitContentRequestDto requestDto) {
        this.visitContent = requestDto.getVisitContent();
    }
}