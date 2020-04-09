package com.example.words.domain.words;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface WordsRepository extends JpaRepository<Words, Long> {

    @Query("SELECT p " +
            "FROM Words p " +
            "ORDER BY p.id DESC")
    Stream<Words> findAllDesc();
}