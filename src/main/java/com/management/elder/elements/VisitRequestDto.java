package com.management.elder.elements;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class VisitRequestDto {
    private Long visitNo;
    private Long visitOldNo;
    private Boolean visitBookmark;
    private String visitContent;
    private LocalDate visitDate;
}
