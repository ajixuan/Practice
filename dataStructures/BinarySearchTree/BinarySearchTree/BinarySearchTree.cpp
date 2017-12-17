// BinarySearchTree.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "BinarySearchTree.h"
#include <cmath>
#include <algorithm>

/*
*0				1
*1			2		   3
*2		4	  5      6    7
*3    8   9 10  11 12 13 14 15
*4	16
*
* num of nodes per level = 2^h
* first index of level   = 2^l - 1 
*   - Because we are using the first node after a full tree level
*/

std::vector<int> trickle(int node, std::vector<int> subtree) {
	//Check root of subtree
	if (subtree[0] > node) {
		trickle(node, subtree.red) {
		}
	
	}
	
	subtree

}



void BST::insert(int node) {
	if (this->tree.size() == 0) {
		this->tree.push_back(node);
		return;
	}

	//Recursively trickle node down
	//Compute the index
	



	this->tree.push_back(node);
}

void BST::print_tree() {
	int total = this->tree.size();
	int h = 0;

	while (total != 0) {
		total >>= 1;
		h++;
	}

	std::cout << h;
	int lstart;
	for (int l = 0; l < h; l++){
		lstart = (std::pow(2, l) - 1);
		for (; lstart < std::pow(2, l+1) - 2; lstart++) {
			std::cout << this->tree[lstart] << "|";
			lstart++;
		}
		printf("/n");
	}
}


int main()
{
	BST bst = BST();
	bst.insert(1);
	bst.insert(2);
	bst.insert(3);
	bst.insert(4);
	bst.print_tree();
    return 0;
}

