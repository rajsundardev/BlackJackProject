package com.game;

// Card actions
public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // To get the value of the card after picked
    public int getValue() {
        if (rank.equals("Ace")) {
            return 1;
        } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }

    public String toString() {
        return rank + " " + suit;
    }
}