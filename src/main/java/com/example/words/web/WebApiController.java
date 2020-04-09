package com.example.words.web;


import com.example.words.service.words.WordsService;
import com.example.words.web.dto.WordsResponseDto;
import com.example.words.web.dto.WordsSaveRequestDto;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class WebApiController {

    private WordsService wordsService;

    @PostMapping("/words")
    public Long saveWords(@RequestBody WordsSaveRequestDto dto) {
        return wordsService.save(dto);
    }


    @GetMapping("/api/v1/words/{id}")
    public WordsResponseDto findById(@PathVariable Long id) {
        return wordsService.findById(id);
    }


}
