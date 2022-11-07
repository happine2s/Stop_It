package com.likelion.stopit.domain;

import com.likelion.stopit.dto.ConsumeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Consume extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn()
    private Tag tagid;

    @ManyToOne
    @JoinColumn() //nullable = false
    private User userid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int cost;

    @Column(nullable = false)
    private boolean regret;

    @Column(nullable = false)
    private boolean onoffline;

    // 소비 내역 등록 시 사용
    public Consume(ConsumeRequestDto requestDto){
        //this.userid=requestDto.getUserid();
        this.name= requestDto.getName();
        this.cost=requestDto.getCost();
        //this.tagid=requestDto.getTagid();
        this.regret= requestDto.getRegret();
        this.onoffline= requestDto.getOnoffline();
    }


    public void update(ConsumeRequestDto requestDto) {
        //this.userid=requestDto.getUserid();
        this.name= requestDto.getName();
        this.cost=requestDto.getCost();
        //this.tagid=requestDto.getTagid();
        //this.regret= requestDto.getRegret(); // 수정 불가 칼럼으로 정함
        this.onoffline= requestDto.getOnoffline();
    }
}
