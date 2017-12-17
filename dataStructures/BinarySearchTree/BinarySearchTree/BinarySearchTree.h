#pragma once
#include <vector>
#include <iostream>
#include <cmath>

class BST {
	std::vector<int> tree;
public:
	//Initialize a 10 level tree
	BST() { this->tree = std::vector<int>((int)std::pow(2, 10), NULL); }
	void trickle(int node, int root);
	void insert(int);
	void print_tree(int level);
};