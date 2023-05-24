package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Dealer perform actions
public class Dealer {

    private String name;
    private List<Card> hand;

    public Dealer(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    // get the name of the card
    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    // Take the card inHand
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

    // create random number to pass the value betn 1 to 2 for either to hit/stand purpose
    public int generateRandomNumber() {
        Random random = new Random();
        int number = random.nextInt(2) + 1;
        return number;
    }

}
