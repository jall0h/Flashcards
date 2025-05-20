package com.codingwithabu.backend.Deck;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingwithabu.backend.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class DeckService {
    private final DeckRepository deckRepository;
    // private final UserRepository userRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public List<Deck> getAllDecks(){
        return deckRepository.findAll();
    }

    public void addNewDeck(Deck deck){
        System.out.println(deck);
        // System.out.println("Deck ID" + deck.getUser().getId());
        deckRepository.save(deck);
    }

    
    public Optional<Deck> getDeck(Integer id){
        return deckRepository.findById(id);
    }

    @Transactional
    public void updateDeck(Integer id, DeckUpdateDTO deckUpdateDTO){
        Deck deck = deckRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException(
                        "deck with id" + id + "does not exists"
                    ));
        String name = deckUpdateDTO.name();
        String description = deckUpdateDTO.description();
        if (name != null && name.length() > 0 && !Objects.equals(deck.getName(), name))
        {
            deck.setName(name);
        }

        if (description != null && description.length() > 0 && !Objects.equals(deck.getDescription(), description))
        {
            deck.setDescription(description);
        }
    }
    public void deleteDeck(Integer id){
        boolean deckExists = deckRepository.existsById(id);
        if (!deckExists) {
            throw new IllegalStateException("deck with id" + id + "does not exists");
        }
        deckRepository.deleteById(id);
    }
    
}
