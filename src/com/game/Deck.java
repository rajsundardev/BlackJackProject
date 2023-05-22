package com.game;

import java.util.ArrayList;
import java.util.List;

// deck which contains the list of cards
public class Deck {
    private List<Card> cards;
    private int cardIndex;

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

    public void shuffle() {
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }

        cardIndex = 0;
    }

    public Card dealCard() {
        if (cardIndex >= cards.size()) {
            throw new IllegalStateException("Deck is empty now!");
        }

        Card card = cards.get(cardIndex);
        cardIndex++;
        return card;
    }
}