import org.junit.Assert;
import org.junit.Test;

public class TestFindNDuplicate {

    @Test
    public void testMakeList() {
        FindNDuplicate nlist = new FindNDuplicate(1, 0);
        nlist.printList();
        Assert.assertEquals(0, nlist.getList()[0]);
        Assert.assertEquals(0, nlist.getList()[1]);

        nlist = new FindNDuplicate(2, 0);
        nlist.printList();
        Assert.assertEquals(0, nlist.getList()[0]);
        Assert.assertEquals(1, nlist.getList()[1]);
        Assert.assertEquals(3, nlist.getList().length);

        nlist = new FindNDuplicate(10, 5);
        nlist.printList();
        Assert.assertEquals(11, nlist.getList().length);
    }

    @Test
    public void testFindDupe(){

    }
}
