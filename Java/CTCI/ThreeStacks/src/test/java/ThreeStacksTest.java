import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

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
    public void testPush() throws IllegalAccessException,  NoSuchFieldException{
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
        Assert.assertEquals(1, tails[0]);

        Assert.assertEquals(5, heads[1]);
        Assert.assertEquals(6, tails[1]);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstruction(){
        stacks = new ThreeStacks<Integer>(0,-1);
    }
}
