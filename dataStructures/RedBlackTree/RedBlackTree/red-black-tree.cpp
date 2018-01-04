#include "red-black-tree.h"
using namespace std;

/*
* If uncle is red do recoloring
* If uncle is black do rotation
*
void RBT::rebalance(int index, int bp) {
	//If parent red
	if (this->tree->color == red) {
		//If uncle red
		if (this->tree[parent + 1]->color == red) {
			//Recolor upper level and check depth
			for (int i = getH(parent) - 1; i < getH(index) - 2; i++) {
				this->tree[i]->color = black;
			}
		}

		this->tree[parent]->color = black;

	} 
	//If depth is violated
	else if (this->bh < bp) {
	
	}
}*/



void RBT::trickle(Node* curr, Node* insert) {
	if (insert->val <= curr->val) {
		if (curr->left) {
			this->trickle(curr->left, insert);
		}
		else {
			curr->left = insert;
			return;
		}
	}
	else {
		if (curr->right) {
			this->trickle(curr->right, insert);
		}
		else {
			curr->right = insert;
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