package com.codingwithabu.backend.Flashcard;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlashcardRepository extends JpaRepository<Flashcard, Integer>{
 //SELECT * from student WHERE email = ?
    @Query("SELECT f FROM Flashcard f WHERE f.deck.id = ?1")
    List<Flashcard> findByDeckId(Integer id);
}
