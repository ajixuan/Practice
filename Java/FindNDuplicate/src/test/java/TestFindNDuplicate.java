import org.junit.Assert;
import org.junit.Test;

public class TestFindNDuplicate {

    @Test
    public void testMakeList() {
        FindNDuplicate nlist = new FindNDuplicate(1, 0);
        Assert.assertEquals(0, nlist.getList()[0]);
        Assert.assertEquals(0, nlist.getList()[1]);

    }
}
