package com.codingwithabu.backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codingwithabu.backend.Deck.Deck;
import com.codingwithabu.backend.Deck.DeckRepository;
import com.codingwithabu.backend.Flashcard.Card;
import com.codingwithabu.backend.Flashcard.CardRepository;
import com.codingwithabu.backend.Flashcard.Flashcard;
import com.codingwithabu.backend.Flashcard.FlashcardRepository;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository, DeckRepository deckRepository, CardRepository cardRepository, FlashcardRepository flashcardRepository) {
        return args -> {
            User bob = new User(
			 "Bob",
			 "bob.jalloh@gmail.com",
			 "bob.jalloh@gmail.com",
             "bob.jalloh@gmail.com",
             "bob.jalloh@gmail.com");

            repository.saveAll(List.of(bob));

            Deck deck = new Deck(
                bob,
                "thing",
                "nice description"
            );
            deckRepository.save(deck);

            Card card = new Card("who is the goat", "lebron james");
            Card card2 = new Card("who is the goat", "MJ");
            cardRepository.saveAll(List.of(card,card2));

            Flashcard flashcard1 = new Flashcard(
                deck,
                card,
                LocalDateTime.now(),
                LocalDateTime.now()
            );
            Flashcard flashcard2 = new Flashcard(
                deck,
                card2,
                LocalDateTime.now(),
                LocalDateTime.now()
            );
            flashcardRepository.saveAll(List.of(flashcard1, flashcard2));

        };
    }
}
