class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        std::map <char, int> map;
        string result = "";
        string buf = "";
        
        if(s.size() == 1){
            return 1;
        }
        
        //if not same, append to result
        for(int i = 0; i < s.length(); i++){
            buf += s[i];
            map[s[i]] = 1;
            for(int j = i+1; j<s.length();j++){
                if(map[s[j]]){
                    break;
                }
                                
                buf += s[j];
                map[s[j]] = 1;
            }
            
            if(buf.length() > result.length()){
                result = buf;
            }
            buf = "";
            map.clear();
        }
        return result.length();
    }
};