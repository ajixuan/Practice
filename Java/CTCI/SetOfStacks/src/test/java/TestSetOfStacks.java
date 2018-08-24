import org.junit.Assert;
import org.junit.Test;

public class TestSetOfStacks {
    @Test
    public void testSetOfStack(){
        SetOfStacks set = new SetOfStacks<Integer>(1);
        set.push(1);
        set.push(2);
        set.push(3);
        set.push(4);
        Assert.assertEquals(4, set.pop());
        Assert.assertEquals(3, set.pop());
        Assert.assertEquals(2, set.pop());
        Assert.assertEquals(1, set.pop());
    }

    @Test
    public void testSetStackBigger(){
        SetOfStacks set = new SetOfStacks<Integer>(3);
        set.push(1);
        set.push(2);
        set.push(3);
        set.push(4);
        Assert.assertEquals(4, set.pop());
        Assert.assertEquals(3, set.pop());
        Assert.assertEquals(2, set.pop());
        Assert.assertEquals(1, set.pop());
    }


    @Test
    public void testStack(){
        MyStack myStack = new MyStack<Integer>();
        Assert.assertEquals(0, myStack.size);
        myStack.push(1);
        Assert.assertEquals(1, myStack.size);
        myStack.push(2);
        Assert.assertEquals(2, myStack.size);
        Assert.assertEquals(2, myStack.pop());
        Assert.assertEquals(1, myStack.size);
        Assert.assertEquals(1, myStack.pop());
        Assert.assertEquals(0, myStack.size);
    }
}
