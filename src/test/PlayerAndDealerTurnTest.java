package test;

import com.game.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerAndDealerTurnTest {

    public static PlayerAndDealerTurn turn;
    Player player;
    Dealer dealer;

    Scanner scanner;
    Deck deck;

    @Before
    public void setUpBefore() throws Exception {
        List<Card> cardList = new ArrayList<>();
        turn = new PlayerAndDealerTurn();
        cardList.add(new Card("Spades", "9"));
        cardList.add(new Card("Hearts", "Ace"));

        deck = new Deck();

        player = new Player("Player1");
        dealer = new Dealer("Dealer1");

        scanner = new Scanner(System.in);

    }

/*    @Test
    public void playerHitTest() throws Exception{
        String io = "hit";

        InputStream inputStream = new ByteArrayInputStream(io.getBytes());

        String input = "hit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        turn.playPlayerTurn(player, deck, scanner);


        Assert.assertEquals(2, player.getHand().size());
        //Assert.assertTrue(player.getHandTotal() >= 2 && player.getHandTotal() <= 21);

    }*/

    @Test
    public void announceWinnerTest() throws Exception {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Create dealers
        Dealer dealer1 = new Dealer("Dealer1");
        Dealer dealer2 = new Dealer("Dealer2");
        List<Dealer> dealers = new ArrayList<>();
        dealers.add(dealer1);
        dealers.add(dealer2);

        // Set hand totals for players and dealers
        player1.addCardToHand(new Card("Hearts", "Ace"));
        player1.addCardToHand(new Card("Spades", "King"));
        dealer1.addCardToHand(new Card("Diamonds", "10"));
        dealer1.addCardToHand(new Card("Clubs", "9"));

        player2.addCardToHand(new Card("Spades", "Queen"));
        dealer2.addCardToHand(new Card("Hearts", "10"));
        dealer2.addCardToHand(new Card("Diamonds", "King"));

        try {
            String result = turn.announceWinners(players, dealers);

            String expectedOutput = "scoring player 1 has 21, dealer has 19 Player 1 wins\n" +
                    "scoring player 2 has 10, dealer has 20 Dealer wins\n";
            Assert.assertEquals(expectedOutput, result);
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }
}
