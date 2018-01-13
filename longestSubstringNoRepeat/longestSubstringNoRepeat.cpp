class Solution {

/*
*   Optimized window sliding solution
**/
public:
    int optimized(string s) {
        
		//Map = (current char : longest length of substring)
        std::map <char, int> map
        int repeatLongest = 0; int cur = 0; int ans = 0;
        
        if(s.size() == 1){
            return 1;
        }
        
        //if not same, append to result
        while(repeatLongest < s.size() && cur < s.size()){

            //C++ method of finding if an element exists
            if(map.find(s[cur]) != map.end()){
				//
                repeatLongest= max(map[s[cur]], i);
            }

			//cur - repeatLongest because 
			// + 1 because you are computing one extra char
			ans = max(ans, cur - repeatLongest + 1); 

			//Store longest of cur char in map
            map[s[cur]] = cur + 1;
            cur++;
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