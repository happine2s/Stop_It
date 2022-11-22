package com.likelion.stopit.domain;

import com.likelion.stopit.dto.ConsumeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Setter
@DynamicUpdate
@DynamicInsert
public class Consume extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn()
    private Tag tag;

    @ManyToOne
    @JoinColumn()
    private Users users;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int cost;

    @Column()
    private Boolean regret;

    @Column()
    private Boolean onoffline;

    // 소비 내역 등록 시 사용
    public Consume(ConsumeRequestDto requestDto){
        this.name= requestDto.getName();
        this.cost=requestDto.getCost();
        this.regret= requestDto.getRegret();
        this.onoffline= requestDto.getOnoffline();
    }

    public void update(String name, int cost, Boolean regret, Boolean onoffline){
        this.name=name;
        this.cost=cost;
        this.regret=regret;
        this.onoffline=onoffline;
    }

}

//    Syntax error in SQL statement
//        "select consume0_.id as id1_0_0_, consume0_.created_at as created_2_0_0_, consume0_.modified_at as modified3_0_0_, consume0_.cost as cost4_0_0_, consume0_.name as name5_0_0_, consume0_.onoffline as onofflin6_0_0_, consume0_.regret as regret7_0_0_, consume0_.tag_id as tag_id8_0_0_, " +
//        "consume0_.user_id as user_id9_0_0_, tag1_.id as id1_1_1_, tag1_.name as name2_1_1_, user2_.id as id1_2_2_, user2_.pwd as pwd2_2_2_, user2_.uid as uid3_2_2_ from consume consume0_ left outer join tag tag1_ on consume0_.tag_id=tag1_.id left outer join [*]user user2_ on consume0_.user_id=user2_.id where consume0_.id=?"; expected "identifier"; SQL statement:
