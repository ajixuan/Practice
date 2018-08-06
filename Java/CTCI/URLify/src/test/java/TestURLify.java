import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestURLify {
    private static URLify url;

    @Before
    public void setup(){
        url = new URLify();
    }

    @Test
    public void testCovert(){
        Assert.assertTrue("test%20test".equals(url.convert("test test")));
        Assert.assertEquals("test%20test",url.convert("  test test   "));
    }

    @Test
    public void testSubArray(){
        char[] test = {' ', ' ', 't', 'e', 's', 't', 'a','b'};
        char[] expect = {'t','e','s','t'};
        char[] result = url.subArr(2,5,test);
        Assert.assertTrue(Arrays.equals(expect, result));
    }

    @Test
    public void testBuildWords(){
        URLify.Word word = url.buildWords("Hello World    ");
        int len = 0;
        char[][] words = new char[2][];

        while(word != null){
            words[len] =  word.arr;
            word = word.next;
            len ++;
        }

        Assert.assertEquals(2, len);
        Assert.assertEquals("[H, e, l, l, o]", Arrays.toString(words[0]));
        Assert.assertEquals("[W, o, r, l, d]", Arrays.toString(words[1]));
    }
}
