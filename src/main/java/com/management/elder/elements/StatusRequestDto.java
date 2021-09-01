package com.management.elder.elements;

import lombok.Getter;

import java.util.Date;

@Getter
public class StatusRequestDto {
    private Long statusNo;
    private Long statusOldNo;
    private String statusElectric;
    private String statusPhone;
    private String statusAll;
    private Date statusDate;
}
