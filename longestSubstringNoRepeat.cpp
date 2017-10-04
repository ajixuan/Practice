class Solution {

/*
*   Optimized window sliding solution
**/
public:
    int optimized(string s) {
        
        std::map <char, int> map;
        int i = 0; int j = 0; int ans = 0;
        
        if(s.size() == 1){
            return 1;
        }
        
        //if not same, append to result
        while(i < s.size() && j < s.size()){

            //C++ method of finding if an element exists
            if(map.find(s[j]) != map.end()){
                i = max(map[s[j]], i);
            }

            ans = max(ans, j - i + 1);            
            map[s[j]] = j + 1;
            j++;
        }

        return ans;
    }


/*
*   Naive solution
**/
public:
    int naive(string s) {
        
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