package com.example.words.domain

import com.example.words.domain.words.Words
import com.example.words.domain.words.WordsRepository
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import java.time.LocalDateTime


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    WordsRepository wordsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {

    }

    @Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        wordsRepository.save(Words.builder()
                .word("테스트 게시글")
                .meaning("테스트 본문")
                .build());
        //when
        List<Words> wordsList = wordsRepository.findAll();

        //then
        Words words = postsList.get(0);
        assertTrue(words.getCreatedDate().isAfter(now));
        assertTrue(words.getModifiedDate().isAfter(now));
    }
}
