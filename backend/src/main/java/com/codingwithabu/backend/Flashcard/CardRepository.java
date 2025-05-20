package com.codingwithabu.backend.Flashcard;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Integer>{
    //SELECT * from cards WHERE id = ?
    @Query("SELECT c from Card c WHERE c.id = ?1")
    Optional<Card> findCardById(Integer id);

}
