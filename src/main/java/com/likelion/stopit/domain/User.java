package com.likelion.stopit.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String uid; //email, id, nickname 뭐로 할까

    @Column(nullable = false)
    private String pwd;
}
