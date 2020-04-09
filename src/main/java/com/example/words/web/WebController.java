package com.example.words.web;

import com.example.words.service.words.WordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class WebController {

    private final WordsService wordsService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("words", wordsService.findAllDesc());
        return "main";
    }



    @GetMapping("/words/save")
    public String wordsSave(){
        return "words-save";
    }
}
