import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStack {

    Stack stack;

    @Before
    public void setup(){
        stack = new Stack<String>();

    }

    @Test
    public void testPush(){
        stack.push("1");
        stack.push("2");
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void testPop(){
        stack.push("1");
        stack.toString();
        Assert.assertEquals(stack.pop(),"1");
    }
}
