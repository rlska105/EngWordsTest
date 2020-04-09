package com.example.words.service.words;


import com.example.words.domain.words.Words;
import com.example.words.domain.words.WordsRepository;
import com.example.words.web.dto.WordsResponseDto;
import com.example.words.web.dto.WordsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class WordsService {

    private WordsRepository wordsRepository;

    @Transactional
    public Long save(WordsSaveRequestDto dto) {
        return wordsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<WordsResponseDto> findAllDesc() {
        return wordsRepository.findAllDesc()
                .map(WordsResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public WordsResponseDto findById(Long id) {
        Words entity = wordsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new WordsResponseDto(entity);
    }
}

