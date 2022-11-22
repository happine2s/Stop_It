package com.likelion.stopit.controller;

import com.likelion.stopit.domain.Consume;
import com.likelion.stopit.domain.ConsumeRepository;
import com.likelion.stopit.dto.ConsumeRequestDto;
import com.likelion.stopit.service.ConsumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ConsumeRestController {
    private final ConsumeRepository consumeRepository;
    private final ConsumeService consumeService;

    //소비 내역 전체 조회
    @GetMapping("/buy/list")
    public List<Consume> getConsumeAll(){
        return consumeRepository.findAll();
    }

    //소비 내역 생성
    @PostMapping ("/buy")
    public Consume createConsume(@RequestBody ConsumeRequestDto requestDto){
        return consumeService.createConsume(requestDto);
    }

    //소비 내역 수정
    @PatchMapping("/buy/{id}")
    public Consume patchConsume(@PathVariable Long id, @RequestBody ConsumeRequestDto requestDto) {
        return consumeService.patchConsume(id, requestDto);
    }

    @DeleteMapping("/buy/{id}")
    public Long delConsume(@PathVariable Long id){
        consumeService.deleteConsume(id);
        return id;
    }
}
