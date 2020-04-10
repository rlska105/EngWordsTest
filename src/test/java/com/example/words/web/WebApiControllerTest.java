package com.example.words.web;



import com.example.words.domain.words.Words;
import com.example.words.domain.words.WordsRepository;
import com.example.words.web.dto.WordsSaveRequestDto;
import com.example.words.web.dto.WordsUpdateRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WordsRepository postsRepository;

    private MockMvc mvc;


    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception {
        //given
        String word = "title";
        String meaning = "content";
        WordsSaveRequestDto requestDto = WordsSaveRequestDto.builder()
                .word(word)
                .meaning(meaning)
                .build();

        String url = "http://localhost:" + port + "/words";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);


        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Words> all = postsRepository.findAll();
        assertThat(all.get(0).getWord()).isEqualTo(word);
        assertThat(all.get(0).getMeaning()).isEqualTo(meaning);
    }


    @Test
    public void Posts_수정된다() throws Exception {

        //given
        Words savedWords = postsRepository.save(Words.builder()
                .word("word")
                .meaning("meaning")
                .build());

        Long updateId = savedWords.getId();
        String expectedWord = "title2";
        String expectedMeaning = "content2";

        WordsUpdateRequestDto requestDto = WordsUpdateRequestDto.builder()
                .word(expectedWord)
                .meaning(expectedMeaning)
                .build();

        String url = "http://localhost:" + port + "/words/" + updateId;

        HttpEntity<WordsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,requestEntity, Long.class);


        //then

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Words> all = postsRepository.findAll();
        assertThat(all.get(0).getWord()).isEqualTo(expectedWord);
        assertThat(all.get(0).getMeaning()).isEqualTo(expectedMeaning);
    }
}