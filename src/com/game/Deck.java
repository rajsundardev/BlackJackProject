package com.game;

import java.util.ArrayList;
import java.util.List;

// deck which contains the list of cards
public class Deck {
    private List<Card> cards;
    private int cardIndex;

    // Deck which contains the pack of 52 cards
    public Deck() {
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        cards = new ArrayList<>();
        for (String rank : ranks) {
            for (String suit : suits) {
                cards.add(new Card(rank, suit));
            }
        }

        cardIndex = 0;
    }

    // shuffle the card when the game started based on the Math formula
    public void shuffle() {
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }

        cardIndex = 0;
    }

    // To get the card with updated deck of card index
    public Card dealCard() {
        if (cardIndex >= cards.size()) {
            throw new IllegalStateException("Deck is empty now!");
        }

        Card card = cards.get(cardIndex);
        cardIndex++;
        return card;
    }
}