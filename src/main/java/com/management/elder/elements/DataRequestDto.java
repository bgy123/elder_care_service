package com.management.elder.elements;

import lombok.Getter;

import java.sql.Date;

@Getter
public class DataRequestDto {
    private Long dataNo;
    private Long dataOldNo;
    private Long dataElectric;
    private Long dataPhone;
    private Date dataDate;
}
