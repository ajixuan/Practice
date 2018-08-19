import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.EmptyStackException;

public class ThreeStacksTest {
    private ThreeStacks stacks;


    @After
    public void teardown(){
        stacks = null;
    }

    @Test
    public void testIsEmpty(){
        stacks = new ThreeStacks<Integer>(1, 1);
        Assert.assertTrue(stacks.isEmpty(0));
        stacks.push(0, 0);

        Assert.assertFalse(stacks.isEmpty(0));
    }


    /**
     * Practicing using reflection
     * This is understandably bad practice, but it is done here as an exercise
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    @Test
    public void testBasicPush() throws IllegalAccessException,  NoSuchFieldException{
        stacks = new ThreeStacks<Integer>(10, 2);
        Class stacksClass = stacks.getClass();

        Field temp = stacksClass.getDeclaredField("heads");
        temp.setAccessible(true);
        int[] heads = (int[]) temp.get(stacks);

        temp = stacksClass.getDeclaredField("tails");
        temp.setAccessible(true);
        int[] tails = (int[]) temp.get(stacks);

        Assert.assertEquals(0, heads[0]);
        Assert.assertEquals(0, tails[0]);

        Assert.assertEquals(5, heads[1]);
        Assert.assertEquals(5, tails[1]);

        stacks.push(0, 0);
        stacks.push(1,1);

        Assert.assertEquals(0, heads[0]);
        Assert.assertEquals(0, tails[0]);

        Assert.assertEquals(5, heads[1]);
        Assert.assertEquals(5, tails[1]);

        stacks.push(0, 1);
        stacks.push(1,2);

        Assert.assertEquals(0, heads[0]);
        Assert.assertEquals(1, tails[0]);

        Assert.assertEquals(5, heads[1]);
        Assert.assertEquals(6, tails[1]);
    }


    @Test
    public void testWrapPush() throws IllegalAccessException,  NoSuchFieldException{
        stacks = new ThreeStacks<Integer>(5, 2);
        Class stacksClass = stacks.getClass();

        Field temp = stacksClass.getDeclaredField("heads");
        temp.setAccessible(true);
        int[] heads = (int[]) temp.get(stacks);

        temp = stacksClass.getDeclaredField("tails");
        temp.setAccessible(true);
        int[] tails = (int[]) temp.get(stacks);

        Assert.assertEquals(0, heads[0]);
        Assert.assertEquals(0, tails[0]);
        Assert.assertEquals(2, heads[1]);
        Assert.assertEquals(2, tails[1]);
        stacks.push(1, 0);
        stacks.push(1, 1);
        stacks.push(1, 2);
        Assert.assertEquals(4, tails[1]);
        Assert.assertEquals(0, heads[0]);

        //Shuffle should occur here
        stacks.push(1, 3);
        Assert.assertEquals(5, tails[1]);
        Assert.assertEquals(1, heads[0]);
    }

    @Test(expected = StackOverflowError.class)
    public void testFullStack(){
        stacks = new ThreeStacks<Integer>(1, 1);
        stacks.push(0,1);
        stacks.push(0,2);
    }


    @Test(expected = EmptyStackException.class)
    public void testBasicPop(){
        stacks = new ThreeStacks<Integer>(5, 2);
        stacks.push(0,1);
        stacks.push(0,2);
        stacks.push(0,3);
        stacks.push(1,4);
        stacks.push(1,5);
        Assert.assertEquals(3, stacks.pop(0));
        Assert.assertEquals(2, stacks.pop(0));
        Assert.assertEquals(1, stacks.pop(0));
        Assert.assertEquals(5, stacks.pop(1));
        Assert.assertEquals(4, stacks.pop(1));
        stacks.pop(0);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstruction(){
        stacks = new ThreeStacks<Integer>(0,-1);
    }
}
