import org.junit.Assert;
import org.junit.Test;

public class TestSortStack {
    @Test
    public void testPushPop() {
        SortStack stack = new SortStack();
        stack.push(0);
        Assert.assertEquals(0, stack.pop());

        stack.push(0);
        stack.push(1);
        Assert.assertEquals(0, stack.pop());


        stack.push(0);
        stack.push(1);
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);

        for(int i = 0; i >=6 ; ++i){
            Assert.assertEquals(i, stack.pop());
        }
    }
}
