package com.management.elder.elements;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "data")
public class Data extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long dataNo;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private Long dataOldNo;

    @Column(nullable = false)
    private Long dataElectric;

    @Column(nullable = false)
    private Long dataPhone;

    @Column(nullable = false)
    private Date dataDate;

    /*@ManyToOne
    @JoinColumn(name = "data_old_no")
    private Old dataOldNo;*/

    // 관심 상품 생성 시 이용합니다.
    public Data(DataRequestDto requestDto) {
        //this.dataNo=requestDto.getDataNo();
        this.dataOldNo=requestDto.getDataOldNo();
        this.dataElectric=requestDto.getDataElectric();
        this.dataPhone=requestDto.getDataPhone();
        this.dataDate=requestDto.getDataDate();
    }

    /*public void updateByItemDto(ItemDto itemDto){
        this.lprice=itemDto.getLprice();
    }
    // 관심 가격 변경 시 이용합니다.
    public void update(ProductMypriceRequestDto requestDto) {
        this.myprice = requestDto.getMyprice();
    }*/
}