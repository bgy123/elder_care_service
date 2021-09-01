package com.management.elder.elements;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "status")
public class Status extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long statusNo;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private Long statusOldNo;

    @Column(nullable = false)
    private String statusElectric;

    @Column(nullable = false)
    private String statusPhone;

    @Column(nullable = false)
    private String statusAll;

    @Column(nullable = false)
    private Date statusDate;

    /*@OneToOne
    @JoinColumn(name = "status_old_no")
    private Old statusOldNo;*/

    // 관심 상품 생성 시 이용합니다.
    public Status(StatusRequestDto requestDto) {
        this.statusNo=requestDto.getStatusNo();
        this.statusOldNo=requestDto.getStatusOldNo();
        this.statusElectric=requestDto.getStatusElectric();
        this.statusPhone=requestDto.getStatusPhone();
        this.statusAll=requestDto.getStatusAll();
        this.statusDate=requestDto.getStatusDate();
    }

    /*public void updateByItemDto(ItemDto itemDto){
        this.lprice=itemDto.getLprice();
    }
    // 관심 가격 변경 시 이용합니다.
    public void update(ProductMypriceRequestDto requestDto) {
        this.myprice = requestDto.getMyprice();
    }*/
}