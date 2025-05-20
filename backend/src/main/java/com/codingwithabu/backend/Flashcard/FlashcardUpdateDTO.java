package com.codingwithabu.backend.Flashcard;

import java.time.LocalDateTime;

import com.codingwithabu.backend.Deck.Deck;

public record FlashcardUpdateDTO(Deck deck,
 LocalDateTime lastReview,
 LocalDateTime nextReview ) {

}
