package com.likelion.stopit.controller;

import com.likelion.stopit.domain.Consume;
import com.likelion.stopit.domain.ConsumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ConsumeRestController {
    private final ConsumeRepository consumeRepository;

    //소비 내역 전체 조회
    @GetMapping("/buy/list")
    public List<Consume> getConsumeAll(){
        return consumeRepository.findAll();
    }
}
