import org.junit.Assert;
import org.junit.Test;

public class TestCoinSum {


    @Test
    public void testOne(){
        CoinSum sum = new CoinSum(new int[]{1,3,5}, 11);
        Assert.assertEquals(3, sum.getCoinSum());
        sum.setSum(12);
        Assert.assertEquals(4, sum.getCoinSum());
        sum.setSum(13);
        Assert.assertEquals(3, sum.getCoinSum());
        sum.setSum(15);
        Assert.assertEquals(3, sum.getCoinSum());


    }

    @Test
    public void testMinCoin(){
        CoinSum sum = new CoinSum(new int[]{1,3,5}, 11);
        Assert.assertEquals(1, sum.findMinCoins(3));
        Assert.assertEquals(2, sum.findMinCoins(2));
        Assert.assertEquals(2, sum.findMinCoins(6));
        Assert.assertEquals(3, sum.findMinCoins(9));
    }
}
