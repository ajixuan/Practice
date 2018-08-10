import org.junit.*;

public class UnrolledListTest {
    private UnrolledList list;

    @Before
    public void reset(){
        list = new UnrolledList<Integer>(10);

    }

    @After
    public void teardown(){
        list = null;
    }

    @Test
    public void testIsEmpty(){
        Assert.assertTrue(list.isEmpty());
        list.push(2);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testPushPop(){
        list.push(1);
        Assert.assertEquals(1, list.pop());
        list.push(1);
        list.push(2);
        Assert.assertEquals(2, list.pop());
    }

    @Test
    public void testGet(){
        list.push(1);
        list.push(2);
        Assert.assertEquals( 2,list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutofBound(){
        list.get(20);
    }
}
