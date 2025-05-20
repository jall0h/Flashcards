package com.codingwithabu.backend.Flashcard;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/flashcards")
public class FlashcardController {
    private final FlashcardService flashcardService;

    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @GetMapping
    public List<Flashcard> getAllFlashcards(){
        return flashcardService.getAllFlashcards();
    }

    @GetMapping(path = "{flashcardId}")
    public Optional<Flashcard> getFlashcard(@PathVariable("flashcardId") Integer id){
        return flashcardService.getFlashcard(id);
    }
    @PutMapping(path = "{flashcardId}")
    public void updateFlashcard(@PathVariable("flashcardId") Integer id,
                                 @RequestBody FlashcardUpdateDTO flashcardUpdateDTO)
        {
            flashcardService.updateFlashcard(id, flashcardUpdateDTO);
        }

    @DeleteMapping(path = "{flashcardID}")
    public void deleteFlashcard(Integer id){
        flashcardService.deleteFlashcard(id);
    }

    @GetMapping(path = "/deck/{deckId}")
    public List<Flashcard> getAllFlashcardsByDeck(@PathVariable("deckId") Integer id){
        return flashcardService.getFlashcardsByDeck(id);
    }

    @PostMapping(path = "/deck/{deckId}")
    public void createNewFlashcard(@PathVariable("deckId") Integer id,
    @RequestBody Card card){
        flashcardService.createNewFlashcard(id, card);
    }
}
