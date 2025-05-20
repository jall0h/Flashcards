package com.codingwithabu.backend.Flashcard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;
    
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping
    public List<Card> getCards(){
        return cardService.getAllCards();
    }

    @GetMapping(path = "{cardId}")
    public Optional<Card> getCard(@PathVariable("cardId") Integer id){
        return cardService.getCard(id);
    }

    @PostMapping
    public void addNewCard(@RequestBody Card card){
        cardService.addNewCard(card);

    }

}
