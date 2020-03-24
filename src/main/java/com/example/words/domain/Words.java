package com.example.words.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Words extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String word;
    private String meaning;

    @Builder
    public Words(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

}
