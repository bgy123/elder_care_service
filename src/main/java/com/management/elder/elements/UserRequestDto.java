package com.management.elder.elements;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private Long userNo;
    private String userId;
    private String userPw;
    private String userName;
    private Boolean userGender;
    private String userPhoneNumber;
    private String userHomePhone;
    private String userEmergencyContact1;
    private String userEmergencyContact2;
    private String userAddress;
    private String userEmail;
    private String userRegion;
    //private String userMemo;
}
