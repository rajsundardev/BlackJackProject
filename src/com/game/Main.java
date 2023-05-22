package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int NO_OF_PLAYERS = 3;

    public static void main(String[] args) {

        PlayerAndDealerTurn turnPlayerAndDealer = new PlayerAndDealerTurn();
        Scanner scanner = new Scanner(System.in);
        int numPlayers = NO_OF_PLAYERS;

        System.out.println("Starting game with 3 players");
        System.out.println("Shuffling.");

        List<Player> players = new ArrayList<>();
        List<Dealer> dealers = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            String playerName = "Dealing to player " + (i + 1) + ", card:";
            String dealerName = "Dealing to computer, card";

            players.add(new Player(playerName));
            dealers.add(new Dealer(dealerName));
        }

        Deck deck = new Deck();
        // shuffle the cards randomly
        deck.shuffle();

        //Player dealer;
        for (Player player : players) {
            player.addCardToHand(deck.dealCard());
            player.addCardToHand(deck.dealCard());
        }

        //display format during start of the execution as expected in the requirement doc
        System.out.println(players.get(0).getName() + players.get(0).getHand());
        System.out.println(players.get(1).getName() + players.get(1).getHand());
        System.out.println(players.get(2).getName() + players.get(2).getHand());
        System.out.println("Dealing to computer, card: face down");

        // player turn to process the cards
        for (Player player : players) {
            turnPlayerAndDealer.playPlayerTurn(player, deck, scanner);
            System.out.println();
        }
        // logic for dealer to process the cards
        for (Dealer dealer : dealers) {
            dealer.addCardToHand(deck.dealCard());
            dealer.addCardToHand(deck.dealCard());
        }

        for (Dealer dealer : dealers) {
            turnPlayerAndDealer.playDealerTurn(dealer);
        }

        System.out.println("\n");
        // need to find the winner, pass the players & dealers arraylist as param
        String winner = turnPlayerAndDealer.announceWinners(players, dealers);
        System.out.println(winner);

    }

    public static void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}