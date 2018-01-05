#include "red-black-tree.h"
using namespace std;

Node* getUncle(Node* curr) {
	if (curr->parent->parent->left == curr) {
		printf("right uncle");
		return curr->parent->parent->right;
	}
	else {
		printf("left uncle");
		return curr->parent->parent->left;
	}
}

/*
* Red and black trees are all about the uncles
* If uncle is red do recoloring
* If uncle is black do rotation
*/
void RBT::rebalance(Node* insert) {
	//If parent red
	Node* parent = insert->parent;
	Node* uncle = getUncle(parent);
	if (parent->color == red) {
		//If uncle red
		//Recolor upper 2 levels and check depth
		if (getUncle(insert)->color == red) {
			uncle->color = black;
			parent->color = black;
			parent->parent->color = black;
		}
		//If uncle black
		else {
			//Parent Left 
			if (parent->parent->left == parent) {
				//Child left
				if (parent->left == insert) {


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
}



void RBT::trickle(Node* curr, Node* insert) {
	if (insert->val <= curr->val) {
		if (curr->left) {
			this->trickle(curr->left, insert);
		}
		else {
			insert->parent = curr;
			curr->left = insert;
			this->rebalance(insert);
			return;
		}
	}
	else {
		if (curr->right) {
			this->trickle(curr->right, insert);
		}
		else {
			insert->parent = curr;
			curr->right = insert;
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

	this->trickle(this->tree, node);
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
}

int main(){
	Node* root = new Node(7);
	RBT& tr = RBT();
	tr.insert(root);
	tr.insert(new Node(2));
	tr.insert(new Node(20));
	tr.insert(new Node(1));
	tr.printTree(root, queue<Node *>());
};