package test;

import com.game.Deck;
import com.game.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeckTest {
    public Deck deck;


    public String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};


    private List<Card> cardList;

    @Before
    public void setBefore() throws Exception {
        cardList = new ArrayList<>();
        cardList.add(new Card("Hearts", "5"));
        cardList.add(new Card("Clues", "6"));
        deck = new Deck();
    }

    @Test
    public void initialSizeOfCards() throws Exception {

        Assert.assertEquals(2, cardList.size());
    }
}
