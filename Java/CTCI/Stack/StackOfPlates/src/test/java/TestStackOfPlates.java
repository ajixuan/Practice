import org.junit.Assert;
import org.junit.Test;

public class TestStackOfPlates {
    @Test
    public void testThreshold(){
        StackOfPlates<Integer> piles= new StackOfPlates<>(10);
        Assert.assertEquals(0, piles.pileSize());
        Assert.assertEquals(1, piles.stackSize());

        for(int i = 0; i < 11; i++){
            piles.push(i);
        }
        Assert.assertEquals(2,piles.stackSize());
        Assert.assertEquals(1,piles.pileSize());
    }
}
