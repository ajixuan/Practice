import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dynamic Programming method:
 *  1. Define a "State", which is a subproblem
 *     Subproblem = whether or not index n and m is a palindrome
 *          - Its a subproblem because it is only a palindrome if the elements between
 *              m and n are palindromes will m and n be palindrome
 *          - Use a 2D array as the cache for solutions
 *
 *          Map:
 *
 *          a | b | a | b | a |
 *        a 1 |   |   |   |   |
 *        b -1| 1 |   |   |   |
 *        a 2 |-1 | 1 |   |   |
 *        b -1| 2 |-1 | 1 |   |
 *        a 3 |-1 | 2 |-1 | 1 |
 *
 *        Check one square right and one square up, thats the substring between the two current strings
 *        - If that string has a positive number, it means it is a palindrome
 *        - If our current square has two matching chars, then it is also a palindrome.
 *        - Add 2 to the val of the previous square, and assign it to the current square
 *
 **/
public class LongestPalindrome {

    public String longestPalindrome(String s){
        String answer = s.substring(0, 1);
        int max = 0;
        List<List<Integer>> cache = new ArrayList<>(s.length());
        for(int i = 0; i < s.length(); i++){
            Integer[] bla = new Integer[s.length() - i];
            Arrays.fill(bla, -1);
            List<Integer> temp = Arrays.asList(bla);
            //Set all single palindromes to true
            temp.set(0, 1);
            cache.add(temp);
        }

        //Complete the cache
        // -2 because the last element will never contain any substring
        for(int i = cache.size()-2; i >= 0; i--){
            List<Integer> col = cache.get(i);
            List<Integer> front = cache.get(i+1);

            //Check substring from point i to point j
            // j > 0, we are excluding 0 because we know the single char's length and is palindrome
            for(int j = col.size() - 1; j > 0; j--){
                int end = j + i;
                int between = 0;

                //j - 2
                // -1 for the next array having one less block than the previous
                // -1 for looking for the square one above the current one
                if(j-2 >= 0) between = front.get(j-2);
                if(s.charAt(end) == s.charAt(i) && between >= 0){
                    int val = between + 2;
                    if(val > max){
                        max = val;
                        // end + 1 because substring end is exclusive
                        answer = s.substring(i, end + 1);
                    }
                    col.set(j, val);
                    continue;
                }
                col.set(j, -1);
            }
        }

        return answer;
    }
}