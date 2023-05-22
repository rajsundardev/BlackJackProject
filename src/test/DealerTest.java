package test;

import com.game.Dealer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DealerTest {

    Dealer dealer;

    @Before
    public void setUpBefore() {
        dealer = new Dealer("DealerName");
    }

    @Test
    public void generateRandomNumber() throws Exception {
       int number =  dealer.generateRandomNumber();
       Assert.assertNotNull(number);
    }

}
