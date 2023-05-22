package com.game;

import java.util.ArrayList;
import java.util.List;

// player class to perform the action
public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    // get the current total of card value inhand
    public int getHandTotal() {
        int total = 0;
        boolean hasAce = false;

        for (Card card : hand) {
            total += card.getValue();
            if (card.getValue() == 1) {
                hasAce = true;
            }
        }

        if (hasAce && total <= 11) {
            total += 10; // counting Ace as 11
        }

        return total;
    }
}