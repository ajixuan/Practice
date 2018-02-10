import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveLongestPalindrome {
    public String longestPalindrome(String s){
        Map<Character, List<Integer>> charIndex = new HashMap<>();
        String answer = "";

        //Run through each char
        //Store char and index in map
        for(int i =0; i<s.length();i++){
            if(charIndex.containsKey(s.charAt(i))){

                //Save key
                List<Integer> matches = charIndex.get(s.charAt(i));
                matches.add(i);

                //Run through each index belonging to key
                for(int match : matches){
                    String sub = s.substring(match,i+1);
                    //If palindrome, check if longer than answer
                    if(this.isPalindrome(sub)){
                        if(sub.length() > answer.length()) answer = sub;
                    }
                }

            }else {
                if(answer == "") answer = s.substring(i, i+1);
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                charIndex.put(s.charAt(i), temp);
            }
        }
        return answer;
    }

    public boolean isPalindrome(String s){
        if(s.length() == 1) return true;

        for(int i=0,j=s.length()-1; i<=j;i++,j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
