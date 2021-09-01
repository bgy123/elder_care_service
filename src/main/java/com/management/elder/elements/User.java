package com.management.elder.elements;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "user")
/*@NamedQuery(
        name="User.findByUserId" ,
        query="select m from User m where m.userId=:userId")*/
public class User extends Timestamped {

    // 식별자가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long userNo;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private Boolean userGender;

    @Column(nullable = false)
    private String userPhoneNumber;

    //@Column(nullable = false)
    private String userHomePhone;

    //@Column(nullable = false)
    private String userEmergencyContact1;

    //@Column(nullable = false)
    private String userEmergencyContact2;

    @Column(nullable = false)
    private String userAddress;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userRegion;

    private String userMemo;

    /*@OneToMany(mappedBy = "scheduleUser")
    private List<Schedule> schedules;
*/
    /*@OneToMany(mappedBy = "oldUser")
    private List<Old> olds;*/

    // requestDto를 이용하여 생성하는 생성자
    public User(UserRequestDto requestDto) {
        this.userNo=requestDto.getUserNo();
        this.userId =requestDto.getUserId();
        this.userPw =requestDto.getUserPw();
        this.userName=requestDto.getUserName();
        this.userGender=requestDto.getUserGender();
        this.userPhoneNumber=requestDto.getUserPhoneNumber();
        this.userHomePhone=requestDto.getUserHomePhone();
        this.userEmergencyContact1=requestDto.getUserEmergencyContact1();
        this.userEmergencyContact2=requestDto.getUserEmergencyContact2();
        this.userAddress=requestDto.getUserAddress();
        this.userEmail=requestDto.getUserEmail();
        this.userRegion=requestDto.getUserRegion();
        //this.userMemo=requestDto.getUserMemo();
    }

    public void updateMemo(UserMemoDto memoDto){
        this.userMemo=memoDto.getUserMemo();
    }

    // user 정보 변경
    public void update(UserRequestDto requestDto) {
        this.userNo=requestDto.getUserNo();
        this.userId =requestDto.getUserId();
        this.userPw =requestDto.getUserPw();
        this.userName=requestDto.getUserName();
        this.userGender=requestDto.getUserGender();
        this.userPhoneNumber=requestDto.getUserPhoneNumber();
        this.userHomePhone=requestDto.getUserHomePhone();
        this.userEmergencyContact1=requestDto.getUserEmergencyContact1();
        this.userEmergencyContact2=requestDto.getUserEmergencyContact2();
        this.userAddress=requestDto.getUserAddress();
        this.userEmail=requestDto.getUserEmail();
        this.userRegion=requestDto.getUserRegion();
        //this.userMemo=requestDto.getUserMemo();
    }


}