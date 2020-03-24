package com.example.words.web;


import com.example.words.WordsService;
import com.example.words.domain.WordsRepository;
import com.example.words.web.dto.WordsSaveRequestDto;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class WebRestController {

    private WordsService wordsService;

    @GetMapping("/home")
    public String home(){
        return "hello";
    }

    @PostMapping("/words")
    public Long saveWords(@RequestBody WordsSaveRequestDto dto){
        return wordsService.save(dto);
    }

}
