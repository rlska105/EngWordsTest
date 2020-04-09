package com.example.words.web;


import com.example.words.service.words.WordsService;
import com.example.words.web.dto.WordsResponseDto;
import com.example.words.web.dto.WordsSaveRequestDto;
import com.example.words.web.dto.WordsUpdateRequestDto;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class WebApiController {

    private final WordsService wordsService;

    @PostMapping("/words")
    public Long saveWords(@RequestBody WordsSaveRequestDto dto) {
        return wordsService.save(dto);
    }

    @PutMapping("/api/v1/words/{id}")
    public Long update(@PathVariable Long id, @RequestBody WordsUpdateRequestDto requestDto) {
        return wordsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/words/{id}")
    public WordsResponseDto findById(@PathVariable Long id) {
        return wordsService.findById(id);
    }


}
