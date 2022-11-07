package com.likelion.stopit.domain;

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

    @Column()
    private boolean regret;

    @Column()
    private boolean onoffline;

}
