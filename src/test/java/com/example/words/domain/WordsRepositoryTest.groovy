package com.example.words.domain

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    WordsRepository postsRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        postsRepository.save(Words.builder()
                .word("테스트 게시글")
                .meaning("테스트 본문")
                .build());

        //when
        List<Words> wordsList = postsRepository.findAll();

        //then
        Words words = wordsList.get(0);
        assertThat(words.getWord(), is("테스트 게시글"));
        assertThat(words.getMeaning(), is("테스트 본문"));
    }
}