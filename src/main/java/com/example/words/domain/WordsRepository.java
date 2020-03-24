package com.example.words.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsRepository extends JpaRepository<Words, Long> {
}
