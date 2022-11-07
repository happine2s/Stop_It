package com.likelion.stopit.service;

import com.likelion.stopit.domain.Consume;
import com.likelion.stopit.domain.ConsumeRepository;
import com.likelion.stopit.dto.ConsumeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ConsumeService {
    private final ConsumeRepository consumeRepository;

    @Transactional
    public Long update(Long id, ConsumeRequestDto requestDto){
        Consume consume=consumeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("해당 상품이 존재하지 않습니다.")
        );
        consume.update(requestDto);
        return id;
    }
}
