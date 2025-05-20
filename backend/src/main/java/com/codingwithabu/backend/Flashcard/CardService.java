package com.codingwithabu.backend.Flashcard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards(){
        return this.cardRepository.findAll();
    }

    public Optional<Card> getCard(Integer id){
        return this.cardRepository.findCardById(id);
    }

    public Card addNewCard(Card card){
        System.out.println(card);
        return cardRepository.save(card);
    }

}
