package com.likelion.stopit.dto;

import lombok.Getter;

@Getter
public class ConsumeRequestDto {
    private String name;
    private int cost;
    private String tag;
    private Boolean regret;
    private Boolean onoffline;

    public ConsumeRequestDto(String name, int cost, String tag, Boolean regret, Boolean onoffline){
        this.name=name;
        this.cost=cost;
        this.tag=tag;
        this.regret=regret;
        this.onoffline=onoffline;
    }
}
