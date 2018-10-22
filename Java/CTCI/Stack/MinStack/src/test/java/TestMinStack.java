import org.junit.Assert;
import org.junit.Test;

public class TestMinStack {

    @Test
    public void testPushPop(){
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assert.assertEquals(4, stack.pop());
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
    }


    @Test
    public void testMinStack(){
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        Assert.assertEquals(1, stack.getMin());
        stack.pop();
        Assert.assertEquals(2, stack.getMin());
        stack.pop();
        Assert.assertEquals(3, stack.getMin());
        stack.pop();
        Assert.assertEquals(4, stack.getMin());
    }

}
