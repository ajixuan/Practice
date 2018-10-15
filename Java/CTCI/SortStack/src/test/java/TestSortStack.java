import org.junit.Assert;
import org.junit.Test;

public class TestSortStack {
    @Test
    public void testPush() {
        SortStack stack = new SortStack();
        stack.push(0);
        Assert.assertEquals(0, stack.pop());

        stack.push(0);
        stack.push(1);
        Assert.assertEquals(0, stack.pop());
    }
}
