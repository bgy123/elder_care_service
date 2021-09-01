package com.management.elder.elements;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Setter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "old")
public class Old extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long oldNo;

    // 반드시 값을 가지도록 합니다.
    /*@Column(nullable = false)
    private Long oldUserNo;*/

    @Column(nullable = false)
    private String oldName;

    @Column(nullable = false)
    private Boolean oldGender;

    @Column(nullable = false)
    private String oldPhoneNumber;

    //@Column(nullable = false)
    private String oldHomePhone;

    //@Column(nullable = false)
    private String oldEmergencyContact1;

    //@Column(nullable = false)
    private String oldEmergencyContact2;

    @Column(nullable = false)
    private String oldAddress;

    @Column(nullable = false)
    private String oldEmail;

    @Column(nullable = false)
    private String oldRegion;

    @Column(nullable = false)
    private String oldState;

    @Column(nullable = false)
    private String oldElectricState;

    @Column(nullable = false)
    private String oldPhoneState;

    @ManyToOne
    @JoinColumn(name = "old_user_no")
    private User oldUser;
/*
    @OneToMany(mappedBy = "dataOldNo")
    private List<Data> data;

    @OneToOne(mappedBy = "statusOldNo")
    private Status status;

    @OneToMany(mappedBy = "visitOldNo")
    private List<Visit> visits;*/

    // 관심 상품 생성 시 이용합니다.
    public Old(OldRequestDto requestDto) {
        //this.oldNo=requestDto.getOldNo();
        //this.oldUserNo=requestDto.getOldUserNo();
        this.oldName=requestDto.getOldName();
        this.oldGender=requestDto.getOldGender();
        this.oldPhoneNumber=requestDto.getOldPhoneNumber();
        this.oldHomePhone=requestDto.getOldHomePhone();
        this.oldEmergencyContact1=requestDto.getOldEmergencyContact1();
        this.oldEmergencyContact2=requestDto.getOldEmergencyContact2();
        this.oldAddress=requestDto.getOldAddress();
        this.oldEmail=requestDto.getOldEmail();
        this.oldRegion=requestDto.getOldRegion();
        this.oldState=requestDto.getOldState();
        this.oldElectricState=requestDto.getOldElectricState();
        this.oldPhoneState=requestDto.getOldPhoneState();
    }

    /*public void updateByItemDto(ItemDto itemDto){
        this.lprice=itemDto.getLprice();
    }
    */

    // 관심 가격 변경 시 이용합니다.
    public void update(OldRequestDto requestDto) {
        //this.oldNo=requestDto.getOldNo();
        //this.oldUserNo=requestDto.getOldUserNo();
        this.oldName=requestDto.getOldName();
        this.oldGender=requestDto.getOldGender();
        this.oldPhoneNumber=requestDto.getOldPhoneNumber();
        this.oldHomePhone=requestDto.getOldHomePhone();
        this.oldEmergencyContact1=requestDto.getOldEmergencyContact1();
        this.oldEmergencyContact2=requestDto.getOldEmergencyContact2();
        this.oldAddress=requestDto.getOldAddress();
        this.oldEmail=requestDto.getOldEmail();
        this.oldRegion=requestDto.getOldRegion();
        this.oldState=requestDto.getOldState();
        this.oldElectricState=requestDto.getOldElectricState();
        this.oldPhoneState=requestDto.getOldPhoneState();
    }
}