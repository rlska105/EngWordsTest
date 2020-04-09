package com.example.words.web.dto;


import com.example.words.domain.words.Words;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WordsListResponseDto {

    private Long id;
    private String word;
    private String meaning;
    private LocalDateTime modifiedDate;

    public WordsListResponseDto(Words entity) {
        this.id = entity.getId();
        this.word = entity.getWord();
        this.meaning = entity.getMeaning();
        this.modifiedDate = entity.getModifiedDate();
    }

}
