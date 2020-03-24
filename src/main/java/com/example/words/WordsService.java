package com.example.words;


import com.example.words.domain.WordsRepository;
import com.example.words.web.dto.WordsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class WordsService {

    private WordsRepository wordsRepository;

    @Transactional
    public Long save(WordsSaveRequestDto dto){
        return wordsRepository.save(dto.toEntity()).getId();
    }
}
