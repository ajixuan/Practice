#include "stdafx.h"
#include "BinarySearchTree.h"
#include <cmath>
#include <algorithm>

/**
* Calculations:
*	Num of nodes per level = 2^h
*	First index of level   = 2^l - 1
*		- Because we are using the first node after a full tree level
*	Children of node       = i*2 +1
*		- Children are separated by 2 times the index number of nodes from parent
**/
void BST::trickle(int node, int root) {
	//Determine the children of root
	if (this->tree[root] == NULL) {
		this->tree[root] = node;
		return;
	}

	//If less trickle to left child
	if (node <= this->tree[root]) {
		std::cout << "less " << root * 2 + 1 << "\n";
		return trickle(node, root * 2 + 1);
	} 
	//If more trickle to right child
	else {
		std::cout << "more " << root * 2 + 2 << "\n";
		return trickle(node, root * 2 + 2);
	}
}

void BST::insert(int node) {
	std::cout << "node: " << node << "\n";

	//Recursively trickle node down
	this->trickle(node, 0);
	for (std::vector<int>::const_iterator i = this->tree.begin(); i != this->tree.begin() + 10; ++i) {
		std::cout << *i << ' ';
	}
	std::cout << "\n";
}

void BST::print_tree() {
	int total = this->tree.size() - 1;
	int h = 0; int lstart;

	while (total != 0) {
		total >>= 1;
		h++;
	}

	for (int l = 0; l < h; l++){
		std::cout << "|";
		lstart = ((int) std::pow(2, l)) - 1;
		for (; lstart <= ((int) std::pow(2, l+1)) - 2; lstart++) {
			std::cout << this->tree[lstart] << "|";
		}
		printf("\n");
	}
}


int main()
{
	//Write tests here
	BST bst = BST();
	bst.insert(1);
	bst.insert(2);
	bst.insert(3);
	bst.insert(4);
	bst.print_tree();
    return 0;
}

