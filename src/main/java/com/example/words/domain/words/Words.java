package com.example.words.domain.words;


import com.example.words.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Words extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String word;
    private String meaning;

    @Builder
    public Words(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public void update(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
    }
}
