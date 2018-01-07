#pragma once
#include "stdafx.h"
#include <vector>
#include <iostream>
#include <queue>

enum Color { red, black };

/**
* Property
*      1. Each node is red or black 1= red, 0 = black
*      2. Root is black and Nils are black
*      4. If node is red, children are black
*      5. black-height = the number of black nodes on all nodes to a nil leaf
*         is the same
*      6. Every path from root to leaf null has same number of blacks
* Path from the root to the farthest nil is no more than twice as long as to
* the shortest leaf
*
* Notes:
*  - Red and black trees are faster at insertion and deletion
*  - AVL trees are faster at search because they are more balanced
*/
class Node {
public:
	Node(int val) {
		this->val = val;
		this->color = red;
		this->left = nullptr;
		this->right = nullptr;
		this->parent = nullptr;
	};
	int val;
	Color color;
	Node* left;
	Node* right;
	Node* parent;
};

class RBT {
	Node* tree;
	int bh = 0;
	int size = 0;
	int h = 0;
public:
	void rebalance(Node*);
	void trickle(Node*, Node*, int);
	void insert(Node*);
	void printTree(Node * curr, std::queue<Node*>& discover);
	//~RBT();
};