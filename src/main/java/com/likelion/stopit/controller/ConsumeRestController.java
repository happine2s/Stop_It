package com.likelion.stopit.controller;

import com.likelion.stopit.domain.Consume;
import com.likelion.stopit.domain.ConsumeRepository;
import com.likelion.stopit.dto.ConsumeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping ("/buy")
    public Consume createConsume(@RequestBody ConsumeRequestDto requestDto){
        Consume consume=new Consume(requestDto);
        consumeRepository.save(consume);
        return consume;
    }
}
