import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

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

        //Test max duplicates
        nlist = new FindNDuplicate(10, 5);
        nlist.printList();
        Assert.assertEquals(11, nlist.getList().length);

        nlist = new FindNDuplicate(20, 5);
        nlist.printList();
        Assert.assertEquals(21, nlist.getList().length);
    }

    @Test
    public void testFindDupeByNegatives(){
        FindNDuplicate nlist = new FindNDuplicate(1, 0);
        HashSet<Integer> sol = nlist.findDupesByNegatives();
        Assert.assertEquals(1, sol.size());

        nlist = new FindNDuplicate(4, 2);
        nlist.printList();
        sol = nlist.findDupesByNegatives();
        Assert.assertEquals(2, sol.size());

        nlist = new FindNDuplicate(20, 5);
        nlist.printList();
        sol = nlist.findDupesByNegatives();
        Assert.assertEquals(5, sol.size());

        nlist = new FindNDuplicate(20, 10);
        nlist.printList();
        Assert.assertEquals(10, sol.size());
    }
}
