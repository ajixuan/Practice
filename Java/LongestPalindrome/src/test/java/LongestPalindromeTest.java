import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestPalindromeTest {
    LongestPalindrome sol;

    @Before
    public void setUp(){
        sol = new LongestPalindrome();
    }


    @Test
    public void testEdge(){
        Assert.assertEquals("a", sol.longestPalindrome("aoeu"));
        Assert.assertEquals("", sol.longestPalindrome(""));

    }

    @Test
    public void testOnePalindrome(){
        Assert.assertEquals("aba", sol.longestPalindrome("abab"));
        Assert.assertEquals("babab", sol.longestPalindrome("babab"));
        Assert.assertEquals("bab", sol.longestPalindrome("aoeuoentababotenhuonetu"));
        Assert.assertEquals("b", sol.longestPalindrome("b"));
        Assert.assertEquals("bbbbb", sol.longestPalindrome("bbbbb"));
    }

    @Test
    public void testMultPalindrome(){
        Assert.assertEquals("cccc", sol.longestPalindrome("ababcccc"));
        Assert.assertEquals("ccc", sol.longestPalindrome("baccc"));
        Assert.assertEquals("aoeucccueoa", sol.longestPalindrome("uaoeucccueoaoeuuw"));
        Assert.assertEquals("ccc", sol.longestPalindrome("bcccoaetuthnoeuerrraccc"));
    }

    @Test
    public void testMultipleSameChar(){
        Assert.assertEquals("adada", sol.longestPalindrome("babadada"));
    }


    @Test
    public void testIsPalindrome(){
        Assert.assertTrue(sol.isPalindrome("aba"));
        Assert.assertTrue(sol.isPalindrome("a"));
        Assert.assertTrue(sol.isPalindrome("bb"));
        Assert.assertTrue(sol.isPalindrome("bbbb"));
        Assert.assertFalse(sol.isPalindrome("aabbcc"));
    }
}

