package com.codingwithabu.backend.Flashcard;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingwithabu.backend.Deck.Deck;
import com.codingwithabu.backend.Deck.DeckRepository;

import jakarta.transaction.Transactional;

@Service
public class FlashcardService {
    private final FlashcardRepository flashcardRepository;
    private final DeckRepository deckRepository;
    private final CardService cardService;

    public FlashcardService(FlashcardRepository flashcardRepository, DeckRepository deckRepository, CardService cardService) {
        this.flashcardRepository = flashcardRepository;
        this.deckRepository = deckRepository;
        this.cardService = cardService;
    }
    
    public List<Flashcard> getAllFlashcards(){
        return flashcardRepository.findAll();
    }

    public Optional<Flashcard> getFlashcard(Integer id){
        return flashcardRepository.findById(id);
    }
    @Transactional
    public void updateFlashcard(Integer id, FlashcardUpdateDTO flashcardUpdateDTO){
        Flashcard flashcard = flashcardRepository.findById(id)
                              .orElseThrow(() -> new IllegalStateException("Flashcard with" + id + "Doesnt exist"));
        LocalDateTime lastReview = flashcardUpdateDTO.lastReview();
        LocalDateTime nextReview = flashcardUpdateDTO.nextReview();
        Deck deck = flashcardUpdateDTO.deck();
        if(lastReview != null ){
            flashcard.setLastReview(lastReview);
        }
        if(nextReview != null ){
            flashcard.setNextReview(nextReview);
        }
        if (deck != null && deck != flashcard.getDeck()){
            flashcard.setDeck(deck);
        }
        
    }
    public void deleteFlashcard(Integer id){
        boolean flashcardExists= flashcardRepository.existsById(id);
        if (!flashcardExists)
        {
            throw new IllegalStateException("Flashcard with" + id + "Doesnt exist");
        }
        flashcardRepository.deleteById(id);
    }

    public List<Flashcard> getFlashcardsByDeck(Integer deckId){
        boolean deckExists = deckRepository.existsById(deckId);
        if (!deckExists)
        {
            throw new IllegalStateException("Deck with" + deckId + "Doesnt exist");
        }
        return flashcardRepository.findByDeckId(deckId);
    }

    public void createNewFlashcard(Integer deckId, Card card){
        Deck deck = deckRepository.findById(deckId)
                    .orElseThrow(() -> new IllegalStateException("Deck with id " + deckId + " doesn't exist"));
        Card newCard = cardService.addNewCard(card);
        Flashcard flashcard = new Flashcard(
            deck,
            newCard,
            null,
            LocalDateTime.now()

        );
        flashcardRepository.save(flashcard);
    }
}
