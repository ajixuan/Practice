// LongestPalindrome.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

class Solution{
public:
	static std::string longestPalindrome(std::string s) {
		for (char& c : s) {
			printf("%c", c);
		}
		return "";

	}
};



int main()
{
	Solution::longestPalindrome("abcabcdabaaba");
}

