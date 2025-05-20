package com.codingwithabu.backend.Flashcard;
import java.time.LocalDateTime;

import com.codingwithabu.backend.Deck.Deck;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flashcards")
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Deck deck;
    @OneToOne
    private Card card;
    private LocalDateTime lastReview;
    private LocalDateTime nextReview;


    public Flashcard(){

    }
    
    public Flashcard(Deck deck, Card card, LocalDateTime lastReview, LocalDateTime nextReview) {
        this.deck = deck;
        this.card = card;
        this.lastReview = lastReview;
        this.nextReview = nextReview;
    }

    public Flashcard(Integer id, Deck deck, Card card, LocalDateTime lastReview, LocalDateTime nextReview) {
        this.id = id;
        this.deck = deck;
        this.card = card;
        this.lastReview = lastReview;
        this.nextReview = nextReview;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Deck getDeck() {
        return deck;
    }
    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public LocalDateTime getLastReview() {
        return lastReview;
    }
    public void setLastReview(LocalDateTime lastReview) {
        this.lastReview = lastReview;
    }
    public LocalDateTime getNextReview() {
        return nextReview;
    }
    public void setNextReview(LocalDateTime nextReview) {
        this.nextReview = nextReview;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((deck == null) ? 0 : deck.hashCode());
        result = prime * result + ((card == null) ? 0 : card.hashCode());
        result = prime * result + ((lastReview == null) ? 0 : lastReview.hashCode());
        result = prime * result + ((nextReview == null) ? 0 : nextReview.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Flashcard other = (Flashcard) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (deck == null) {
            if (other.deck != null)
                return false;
        } else if (!deck.equals(other.deck))
            return false;
        if (card == null) {
            if (other.card != null)
                return false;
        } else if (!card.equals(other.card))
            return false;
        if (lastReview == null) {
            if (other.lastReview != null)
                return false;
        } else if (!lastReview.equals(other.lastReview))
            return false;
        if (nextReview == null) {
            if (other.nextReview != null)
                return false;
        } else if (!nextReview.equals(other.nextReview))
            return false;
        return true;
    }

    
}
