package com.codingwithabu.backend.Deck;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingwithabu.backend.Flashcard.Flashcard;

@RestController
@RequestMapping(path = "/decks")
public class DeckController {
    private final DeckService deckService;

    
    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }
    @GetMapping
    public List<Deck> getAllDecks(){
        return deckService.getAllDecks();
    }
    @PostMapping
    public void createNewDeck(@RequestBody Deck deck){
        deckService.addNewDeck(deck);
    }

    @GetMapping(path = "{deckId}")
    public Optional<Deck> getDeck(@PathVariable("deckId") Integer id){
        return deckService.getDeck(id);
    }

    @PostMapping(path = "{deckId}")
    public void addNewCardToDeck(@RequestBody Flashcard flashcard){
        System.out.println("New card being added buddy");
    }

    @PutMapping(path = "{deckId}")
    public void updateDeck(@PathVariable("deckId") Integer id,
    @RequestBody DeckUpdateDTO deckUpdateDTO){
        System.out.println(deckUpdateDTO);
        deckService.updateDeck(id, deckUpdateDTO);

    }
    
    @DeleteMapping(path = "{deckId}")
    public void removeDeck(@PathVariable("deckId") Integer id){
        deckService.deleteDeck(id);
    }




}
