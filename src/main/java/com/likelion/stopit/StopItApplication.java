package com.likelion.stopit;

import com.likelion.stopit.domain.Tag;
import com.likelion.stopit.domain.TagRepository;
import com.likelion.stopit.dto.TagCreateDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StopItApplication {

    public static void main(String[] args) {
        SpringApplication.run(StopItApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(TagRepository tagRepository){
        return (args) -> {
            tagRepository.save(new Tag("옷"));
            tagRepository.save(new Tag("가방"));
            tagRepository.save(new Tag("신발"));
            tagRepository.save(new Tag("음식"));
        };
    }
}
