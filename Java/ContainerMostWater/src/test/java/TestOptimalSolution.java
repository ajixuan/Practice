import org.junit.Assert;
import org.junit.Test;

public class TestOptimalSolution {
    @Test
    public void testSimple() {
        Solution sol = new Solution();
        int[] test = {3, 7};
        Assert.assertEquals(3, sol.optimal(test));
        test = new int[]{3, 7, 3};
        Assert.assertEquals(6, sol.optimal(test));
        test = new int[]{3, 10, 10, 3};
        Assert.assertEquals(10, sol.optimal(test));
    }

    @Test
    public void testLen() {
        Solution sol = new Solution();
        int[] test = {1, 2, 1};
        Assert.assertEquals(2 * 1, sol.optimal(test));
    }


}
