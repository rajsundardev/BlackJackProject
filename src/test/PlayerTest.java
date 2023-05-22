package test;

import com.game.Card;
import com.game.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;

public class PlayerTest {

    Player player;

    @Before
    public void setUpBefore() throws Exception {
        player = new Player("Hearts");
    }

    @Test
    public void getName() throws Exception {
        Assert.assertEquals("Hearts", player.getName());
    }

    @Test
    public void getHand() throws Exception {
        Assert.assertNotNull(player.getHand());
        Assert.assertEquals(0, player.getHand().size());
    }

    @Test
    public void getCardToHand() throws Exception {
        Card card = new Card("Spades", "Ace");
        player.addCardToHand(card);
        Assert.assertEquals(1, player.getHand().size());
        Assert.assertEquals(card, player.getHand().get(0));
    }

    @Test
    public void getHandTotalWithAceCard() throws Exception {
        Card card = new Card("Diamonds", "Ace");
        Card card1 = new Card("Clubs", "8");
        player.addCardToHand(card);
        player.addCardToHand(card1);

        //System.out.println(player.getHandTotal());
        try {
            Assert.assertEquals(19, player.getHandTotal());
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }

    @Test
    public void getHandTotalOfCards() {
        Card card = new Card("Hearts", "Ace");
        Card card1 = new Card("Spades", "King");
        Card card2 = new Card("Diamonds", "5");

        player.addCardToHand(card);
        player.addCardToHand(card1);
        player.addCardToHand(card2);

        try {
            Assert.assertEquals(11, player.getHandTotal());
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }
}
