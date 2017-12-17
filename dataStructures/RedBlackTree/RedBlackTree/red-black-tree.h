#pragma once
#include "stdafx.h"
#include <vector>
#include <iostream>

enum Color { red, black };

class Node {
public:
	Node(int);
	int val;
	Color color;
};

class RedBlackTree {
public:
	void insert(Node&);
	std::vector<Node> tree;
};