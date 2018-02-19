import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestPalindromeTest {
    NaiveLongestPalindrome naive;
    LongestPalindrome optimal;

    @Before
    public void setUp(){
        naive = new NaiveLongestPalindrome();
        optimal = new LongestPalindrome();
    }


    @Test
    public void testEdge(){
        Assert.assertEquals("a", optimal.longestPalindrome("aoeu"));
        Assert.assertEquals("a", optimal.longestPalindrome("aoeu"));
        Assert.assertEquals("", naive.longestPalindrome(""));
        Assert.assertEquals("", naive.longestPalindrome(""));

    }

    @Test
    public void testOnePalindrome(){
        Assert.assertEquals("bab", optimal.longestPalindrome("abab"));
        Assert.assertEquals("babab", optimal.longestPalindrome("babab"));
        Assert.assertEquals("bab", optimal.longestPalindrome("aoeuoentababotenhuonetu"));
        Assert.assertEquals("b", optimal.longestPalindrome("b"));
        Assert.assertEquals("bbbbb", optimal.longestPalindrome("bbbbb"));
    }

    @Test
    public void testMultPalindrome(){
        Assert.assertEquals("cccc", optimal.longestPalindrome("ababcccc"));
        Assert.assertEquals("ccc", optimal.longestPalindrome("baccc"));
        Assert.assertEquals("aoeucccueoa", optimal.longestPalindrome("uaoeucccueoaoeuuw"));
        Assert.assertEquals("ccc", optimal.longestPalindrome("bcccoaetuthnoeuerrraccc"));
    }

    @Test
    public void testMultipleSameChar(){
        Assert.assertEquals("adada", optimal.longestPalindrome("babadada"));
        Assert.assertEquals("abababa", optimal.longestPalindrome("xxaxxabababa"));

    }

    @Test
    public void testIsPalindrome(){
        Assert.assertTrue(naive.isPalindrome("aba"));
        Assert.assertTrue(naive.isPalindrome("a"));
        Assert.assertTrue(naive.isPalindrome("bb"));
        Assert.assertTrue(naive.isPalindrome("bbbb"));
        Assert.assertFalse(naive.isPalindrome("aabbcc"));
    }
}

