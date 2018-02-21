// MyAtoi.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "MyAtoi.h"


/**The string dataStructure
*  - Just a pointer/array of chars
*  - Dereferencing the string will give you the first char
*  - Iterators are just pointers to char at index
**/
int MyAtoi::myAtoi(std::string str) 
{
	int ans = 0;
	for(std::string::iterator it = str.begin(); it != str.end(); ++it){
		//Move over one decimal place

		//Narrow down ascii to only the numbers
		//If the value is under 0x3A or 58
		if ((((int)*it) & ~0x3F) == 0 && *it > 0x30) {
			ans *= 10;
			ans += ((int)*it) % 0x30; //Because 0x30 is "0", use mod to set number to 0
			std::cout << (((int)*it) % 0x30) << std::endl;
		}
	}
	
	return ans;
};


int main()
{
	MyAtoi atoi = MyAtoi();
	std::cout << atoi.myAtoi("124,c.rrc,p.3aoeu123214");
    return 0;
}

