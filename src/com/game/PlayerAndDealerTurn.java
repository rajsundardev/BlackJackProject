package com.game;

import java.util.List;
import java.util.Scanner;

public class PlayerAndDealerTurn {


    public static void playPlayerTurn(Player player, Deck deck, Scanner scanner) {
        while (true) {
            System.out.println(player.getName() + " " + player.getHand() + " " + "Hit or Stand ? >");
            System.out.println("Your total: " + player.getHandTotal());
            //System.out.print("Do you want to hit or stand? (hit/stand): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("hit")) {
                player.addCardToHand(deck.dealCard());
                int handTotal = player.getHandTotal();
                if (handTotal > 21) {
                    System.out.println("Busted over " + handTotal);
                    break;
                } else if (handTotal == 21) {
                    System.out.println("Blackjack! Your total is " + handTotal);
                    break;
                }
            } else if (choice.equalsIgnoreCase("stand")) {
                break;
            }
        }
    }

    //dealer conditions
    public static void playDealerTurn(Dealer dealer) {

        // plan to hit / stand each time randomly
        while (true) {

            int choice = dealer.generateRandomNumber();
            if (choice == 1) { // hit here
                System.out.print(dealer.getName() + " " + dealer.getHand() + " ");
                System.out.println("hit");
                //dealer.addCardToHand(deckDealer.dealCard());
                break;
            } else if (choice == 2) { //stand
                System.out.println(dealer.getName() + " " + dealer.getHand() + " stand");
                break;
            }
        }

    }


    // winnner among the players and dealers
    public static String announceWinners(List<Player> players, List<Dealer> dealers) {
        StringBuffer winnerBuffer = new StringBuffer();
        int playerCount = 1;
        for (Dealer dealer : dealers) {

            int playerTotal = players.get(playerCount - 1).getHandTotal();
            int dealerTotal = dealer.getHandTotal();
            winnerBuffer.append("scoring player " + playerCount + " has " + playerTotal + ", ");
            winnerBuffer.append("dealer has " + dealerTotal);

            if (playerTotal > dealerTotal) {
                winnerBuffer.append(" Player " + playerCount + " wins");
            } else if (dealerTotal > playerTotal) {
                winnerBuffer.append(" Dealer wins");
            } else {
                winnerBuffer.append(" Draw Match");
            }
            winnerBuffer.append("\n");

            playerCount++;

        }

        return winnerBuffer.toString();
    }
}
