#include "red-black-tree.h"
#include "stdafx.h"
using namespace std;

/*
* Assuming we only insert above 2 levels
*/
Node* getUncle(Node* curr) {
	if (curr->parent->parent->left == curr) {
		printf("right uncle");
		return curr->parent->parent->right;
	}
	else {
		printf("left uncle");
		return curr->parent->parent->left;
	}
};

/*
* Red and black trees are all about the uncles
* If uncle is red do recoloring
* If uncle is black do rotation
*/
void RBT::rebalance(Node* insert) {
	//Only rebalance if there are more than 2 levels
	//Other wise it is not necessary
	if (this->h < 2) {
		return;
	}

	//If parent red
	Node* parent = insert->parent;
	Node* uncle = getUncle(parent);
	if (parent->color == red) {
		//If uncle red
		//Recolor upper 2 levels and check depth
		if (getUncle(insert)->color == red) {
			uncle->color = black;
			parent->color = black;
			parent->parent->color = red;
		}
		//If uncle black
		else {
			//Parent Left 
			if (parent->parent->left == parent) {
				//Child left:
				//Rotate sub tree starting from grand parent right
				//Dealing with rights:
				//The grandparent used to have a left, but after rotate the 
				//left becomes the parent. So any sibling of current insert
				//goes onto the left of the previous root
				if (parent->left == insert) {
					//Relocate right
					//You should always manipulate the top level nodes first
					//Because you do not have direct access to them. If you sever
					//your relative links before you complete all changes to the 
					//indirect nodes then you lose reference to them
					Node* rootbranch = parent->parent->parent;
					parent->parent->parent = parent->parent->left;
					parent->parent->left = parent->right;
					parent->right = parent->parent;

					//Severing link
					parent->parent = rootbranch;

					//Recolor
					parent->color = black;
					parent->right->color = red;
				}
				//Child right
				else if (parent->right == insert) {


				}
			} 
			//Parent right
			else if(parent->parent->right == parent){
				//Child left
				if (parent->left == insert) {


				}
				//Child right
				else if (parent->right == insert) {


				}
			}
		}
	} 
};

void RBT::trickle(Node* curr, Node* insert, int h) {
	//Less
	if (insert->val <= curr->val) {
		if (curr->left) {
			this->trickle(curr->left, insert, h+1);
			return;
		}
		else {
			insert->parent = curr;
			curr->left = insert;
			this->h = h;
			this->rebalance(insert);
			return;
		}
	}
	//Greater
	else {
		if (curr->right) {
			this->trickle(curr->right, insert, h+1);
			return;
		}
		else {
			insert->parent = curr;
			curr->right = insert;
			this->h = h;
			this->rebalance(insert);
			return;
		}
	}
};

void RBT::insert(Node* node){
	if (this->tree == nullptr) {
		node->color = black;
		this->tree = node;
		this->bh = 2;
		return;
	}

	this->trickle(this->tree, node, 0);
};

/*
* Print using BFS
* Keep a queue of nodes. When new node 
* discovered, push node onto queue.
*/
void RBT::printTree(Node* curr, queue<Node*>& discover) {
	printf("|%d,%d| ", curr->val, curr->color);
	
	if (curr->left) {
		discover.push(curr->left);
	}
	
	if (curr->right) {
		discover.push(curr->right);
	}

	if (discover.empty()) {
		return;
	}



	Node* next = discover.front();
	discover.pop();
	this->printTree(next, discover);
};

int main(){
	Node* root = new Node(7);
	RBT& tr = RBT();
	tr.insert(root);
	//tr.insert(new Node(2));
	//tr.insert(new Node(20));
	tr.insert(new Node(1));
	tr.printTree(root, queue<Node *>());
};