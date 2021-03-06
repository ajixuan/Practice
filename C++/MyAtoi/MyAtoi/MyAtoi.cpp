// MyAtoi.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "MyAtoi.h"

/*
* This works by filling up all the positions before the MSB,
* then shifting itself right by one and subtracting, thus always
* leaving only the msb
*/
bool getHighestBit(int i) {
	i |= (i >> 1);
	i |= (i >> 2);
	i |= (i >> 4);
	i |= (i >> 8);
	i |= (i >> 16);
	return i - (((unsigned)i) >> 1);
}

/**The string dataStructure
*  - Just a pointer/array of chars
*  - Dereferencing the string will give you the first char
*  - Iterators are just pointers to char at index
**/
int MyAtoi::myAtoi(std::string str) 
{
	int ans = 0;
	int sign = 0;
	std::string::iterator it = str.begin();

	for(; it != str.end(); ++it){
		//Skip all leading space
		if (((int)*it) == 32 && ans == 0 && sign == 0) continue;

		//If its a sign
		if ((*it == 45 || *it == 43) && sign == 0) {
			sign = *it;
			continue;
		}

		//Narrow down ascii to only the numbers
		//If the value is under 0x3A or 58
		if (!((((int)*it) & ~0x3F) == 0 && *it >= 0x30)) {
			break;
		}

		//Move over one decimal place
		//Check for overflow
		if (ans & 0x20000000) {
			ans = -1;
			break;
		}
		ans *= 10;		//Shift over by one dec
		
		//Check for overflow
		
		ans += ((int)*it) % 0x30;	//Because 0x30 is "0", use mod to set number to 0
		//std::cout << (((int)*it) % 0x30) << std::endl;
	}

	//Leetcode requirement:
	//Check for overflow:
	if (ans < 0) {
		return (sign == 45) ? 0x80000000 : 0x7FFFFFFF;
	}
	return (sign == 45) ? 0 - ans: ans;
};


int main()
{
	MyAtoi atoi = MyAtoi();
	std::cout << atoi.myAtoi("    10522545459");
    return 0;
}

