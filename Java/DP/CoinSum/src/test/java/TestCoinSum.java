import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCoinSum {

    CoinSum sum;


    @Before
    public void setup(){
        this.sum = new CoinSum();
    }

    @Test
    public void testOne(){
        Assert.assertEquals(3, sum.coinChange(new int[]{1,3,5}, 11));
        Assert.assertEquals(4, sum.coinChange(new int[]{1,3,5}, 12));
        Assert.assertEquals(3, sum.coinChange(new int[]{1,3,5}, 13));
        Assert.assertEquals(3, sum.coinChange(new int[]{1,3,5}, 15));
    }


    @Test
    public void testMinCoin(){
        CoinSum sum = new CoinSum();
        Assert.assertEquals(1, sum.findMinCoins(new int[]{1,3,5}, 1));
        Assert.assertEquals(2, sum.findMinCoins(new int[]{1,3,5}, 2));
        Assert.assertEquals(2, sum.findMinCoins(new int[]{1,3,5}, 6));
        Assert.assertEquals(3, sum.findMinCoins(new int[]{1,3,5}, 9));
    }

    @Test
    public void testEdges() {
        Assert.assertEquals(-1, sum.coinChange(new int[]{2}, 1));
        Assert.assertEquals(-1, sum.coinChange(new int[]{2}, 3));
        Assert.assertEquals(2, sum.coinChange(new int[]{2}, 4));
    }

    @Test
    public void testHard() {
        //Assert.assertEquals(4, sum.coinChange(new int[]{2,5,10,1}, 27));
        Assert.assertEquals(20, sum.coinChange(new int[]{186,419,83,408}, 6249));
    }
}
