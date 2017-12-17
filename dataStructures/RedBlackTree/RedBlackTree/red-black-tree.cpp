#include <vector>
#include <iostream>
#include "red-black-tree.h"
using namespace std;
/**
 * Property
 *      1. Each node is red or black 1= red, 0 = black
 *      2. Root is black
 *      3. Nils are black
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

Node::Node(int val) {
	this->val = val;
}


void RedBlackTree::insert(Node& node){
        if(this->tree.empty()){
			node.color = red;
			tree.push_back(node);
            return;
        }

		node.color = red;


		//Recolor first
		
		
		//Rotate




		//Standard bst
        //root.length / 2;
};


int main(){
	Node& root = Node(7);
	RedBlackTree& tr = RedBlackTree();
	tr.insert(root);
	cout << tr.tree[0].val << tr.tree[0].color;



};