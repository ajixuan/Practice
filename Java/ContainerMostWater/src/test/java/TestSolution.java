import org.junit.Assert;
import org.junit.Test;

public class TestSolution {
    @Test
    public void testSimple(){
        Solution sol = new Solution();
        int[] test = {3, 7};
        Assert.assertEquals(3*3,sol.maxArea(test));
    }

    @Test
    public void testLen(){
        Solution sol = new Solution();
        int[] test = {1, 2, 1};
        Assert.assertEquals(2*1,sol.maxArea(test));
    }
}
