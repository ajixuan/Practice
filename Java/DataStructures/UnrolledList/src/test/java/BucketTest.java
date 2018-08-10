import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BucketTest {

    private Bucket bucket;

    @Before
    public void setup(){
        this.bucket = new Bucket<Integer>(10);
    }

    @After
    public void tearDown(){
        this.bucket = null;
    }

    @Test
    public void testEmpty(){
        Assert.assertTrue(this.bucket.isEmpty());
    }


    @Test
    public void testSimpleInsert(){
        for(int i = 0; i < 9; i ++){
            this.bucket.insert(i, i);
        }

        Assert.assertEquals(0, this.bucket.getAt(0));
        Assert.assertEquals(1, this.bucket.getAt(1));
        Assert.assertEquals(2, this.bucket.getAt(2));
        Assert.assertEquals(3, this.bucket.getAt(3));
        Assert.assertEquals(8, this.bucket.getAt(8));
        Assert.assertEquals(9, this.bucket.getAt(9));
    }

    @Test
    public void testBucketInsert(){
        for(int i = 0; i <= 10; i ++){
            this.bucket.insert(i, i);
        }
        Assert.assertEquals(9, this.bucket.getAt(9));
        Assert.assertEquals(10, this.bucket.getAt(10));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutofBounds(){
        for(int i = 0; i <= 9; i ++){
            this.bucket.insert(i, i);
        }
        this.bucket.remove(9);
        this.bucket.getAt(9);
        Assert.fail("Expected out of bounds exception");
    }

    @Test
    public void testRemove(){
        for(int i = 0; i <= 9; i ++){
            this.bucket.insert(i, i);
        }
        this.bucket.remove(9);
        Assert.assertEquals(8, this.bucket.getAt(8));
        this.bucket.remove(0);
        Assert.assertEquals(1, this.bucket.getAt(0));

        for(int i = 0; i <= 7; i ++){
            this.bucket.remove(0);
        }

        Assert.assertTrue(this.bucket.isEmpty());

    }
}
