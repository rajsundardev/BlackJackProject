package test;

import com.game.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

    String rank = "Ace";
    String suit = "Hearts";
    Card card;

    @Before
    public void setUpBefore() throws Exception {
        card = new Card(rank, suit);
    }

    @Test
    public void getValue() throws Exception {
        Assert.assertEquals(1, card.getValue());

    }

}
