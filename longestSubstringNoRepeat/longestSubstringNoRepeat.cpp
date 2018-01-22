#include <string>
#include <iostream>
#include <map>
using namespace std;

class Solution {

	/*
	*   Optimized window sliding solution
	**/
public:
	static int optimized(string s) {
		//Map = (curr char: longest length of its substring)
		map <char, int> map;

		//Head and tail of the sliding window
		//head = cursor, advancing down the string
		//tail = the position behind head where the last 
		//repeat of the head char is located
		int tail = 0; int head = 0; int ans = 0;

		if (s.size() == 1) {
			return 1;
		}

		while (tail < s.size() && head < s.size()) {
			//If this char already exist in map
			if (map.find(s[head]) != map.end()) {
				//Tail is updated to the closest next repeat char
				tail = max(map[s[head]], tail);
			}

			//head - tail because we calculate from tail to head
			//+ 1 because its number of chars not index
			ans = max(ans, head - tail + 1);

			//Store longest of cur char in map
			//+1 to exclude curr char because it is duplicate
			map[s[head]] = head + 1;
			head++;
		}

		cout << ans;
		return ans;
	}


	/*
	*   Naive solution
	**/
public:
	static int naive(string s) {

		map <char, int> map;
		string result = "";
		string buf = "";

		if (s.size() == 1) {
			return 1;
		}

		//if not same, append to result
		for (int i = 0; i < s.length(); i++) {
			buf += s[i];
			map[s[i]] = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (map[s[j]]) {
					break;
				}

				buf += s[j];
				map[s[j]] = 1;
			}

			if (buf.length() > result.length()) {
				result = buf;
			}
			buf = "";
			map.clear();
		}
		return result.length();
	}
};


int main() {
	Solution::optimized("aabotegkmdthaeodunt");
}