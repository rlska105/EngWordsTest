package com.example.words.service.words;


import com.example.words.domain.words.Words;
import com.example.words.domain.words.WordsRepository;
import com.example.words.web.dto.WordsListResponseDto;
import com.example.words.web.dto.WordsResponseDto;
import com.example.words.web.dto.WordsSaveRequestDto;
import com.example.words.web.dto.WordsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WordsService {

    private final WordsRepository wordsRepository;

    @Transactional
    public Long save(WordsSaveRequestDto requestDto) {
        return wordsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, WordsUpdateRequestDto requestDto) {
        Words words = wordsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        words.update(requestDto.getWord(), requestDto.getMeaning());
        return id;
    }

    @Transactional(readOnly = true)
    public List<WordsListResponseDto> findAllDesc() {
        return wordsRepository.findAllDesc().stream()
                .map(WordsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true) //GetMapping 조회
    public WordsResponseDto findById(Long id) {
        Words entity = wordsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new WordsResponseDto(entity);
    }
}

