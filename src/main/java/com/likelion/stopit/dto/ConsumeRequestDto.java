package com.likelion.stopit.dto;

import lombok.Getter;

@Getter
public class ConsumeRequestDto {
    //private Long userid;
    private String name;
    private int cost;
    //private Long tagid;
    private Boolean regret; //nullable=true
    private Boolean onoffline; //nullable=true
}
