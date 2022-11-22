package com.likelion.stopit.service;

import antlr.StringUtils;
import com.likelion.stopit.domain.Consume;
import com.likelion.stopit.domain.ConsumeRepository;
import com.likelion.stopit.domain.Tag;
import com.likelion.stopit.domain.TagRepository;
import com.likelion.stopit.dto.ConsumeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConsumeService {

    private final ConsumeRepository consumeRepository;

    private final TagRepository tagRepository;

    public Consume createConsume(ConsumeRequestDto requestDto) {
        Consume consume=new Consume(requestDto);
        String requestTag=requestDto.getTag();
        Optional<Tag> tagOptional = tagRepository.findByName(requestTag);

        // 요청 태그가 있다면 소비내역 객체에 저장하기
        if (tagOptional.isPresent()) {
            consume.setTag(tagOptional.get()); // Optional 공부하기
        }
        //요청 태그가 없다면 태그 객체를 생성하고 소비내역에 저장하기
        else {
            Tag tag1 = new Tag(requestTag);
            tagRepository.save(tag1);
            consume.setTag(tag1);
        }
        return consumeRepository.save(consume);
    }

    @Transactional
    public Consume patchConsume(Long id, ConsumeRequestDto requestDto) {
        Optional<Consume> consumeOptional=consumeRepository.findById(id);

        if(consumeOptional.isPresent()){ //url의 consume{id}가 있다면
            System.out.println("present");
            Consume consume = consumeOptional.get();
            if(requestDto.getName()!=null){
                consume.setName(requestDto.getName());
            }
            if(requestDto.getCost()!=0){
                consume.setCost(requestDto.getCost());
            }
            if(requestDto.getRegret()!=null){
                consume.setRegret(requestDto.getRegret());
            }
            if(requestDto.getOnoffline()!=null){
                consume.setOnoffline(requestDto.getOnoffline());
            }
            if(requestDto.getTag()!=null){
                String rqTag=requestDto.getTag();
                Optional<Tag> oTag = tagRepository.findByName(rqTag);

                // 요청 태그가 있다면 소비내역 객체에 저장하기
                if (oTag.isPresent()) {
                    consume.setTag(oTag.get()); // Optional 공부하기
                }
                //요청 태그가 없다면 태그 객체를 생성하고 소비내역에 저장하기
                else {
                    Tag tag1 = new Tag(rqTag);
                    tagRepository.save(tag1);
                    consume.setTag(tag1);
                }
            }
            return consumeRepository.save(consume);
        }
        return null;
    }

    @Transactional
    public void deleteConsume(Long id){
        System.out.println(id);
        Consume consume=consumeRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 내역이 없습니다. id="+id)
        );
        consumeRepository.delete(consume);
    }
}
