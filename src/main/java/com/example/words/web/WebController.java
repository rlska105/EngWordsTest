package com.example.words.web;

import com.example.words.service.words.WordsService;
import com.example.words.web.dto.WordsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class WebController {

    private final WordsService wordsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("words", wordsService.findAllAsc());
        return "main";
    }

    @GetMapping("/words/save")
    public String wordsSave() {
        return "words-save";
    }

    @GetMapping("/words/update/{id}")
    public String wordsUpdate(@PathVariable Long id, Model model) {
        WordsResponseDto dto = wordsService.findById(id);
        model.addAttribute("post", dto);
        return "words-update";
    }
}
