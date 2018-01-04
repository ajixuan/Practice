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
}



void RBT::trickle(Node* node, int root, int bp) {
	//Count the number of black nodes as we trickle down
	if (this->tree[root]->color == black) bp++;

	//If we have reached leaf check for rotations
	if (this->tree[root] == nullptr) {
		this->tree[root] = &node;
		this->rebalance(root, bp);
	}

	if (node.val <= this->tree[root]->val) {
		return this->trickle(node, root * 2 + 1, bp);
	}
	else if (node.val > this->tree[root]->val) {
		return this->trickle(node, root * 2 + 2, bp);
	}
};*/

void RBT::insert(Node* node){
	if (this->tree == nullptr) {
		node->color = black;
		this->tree = node;
		this->bh = 2;
		return;
	}

	//this->trickle(node, 0, 1);
};

/*
* Print using BFS
* Keep a queue of nodes. When new node 
* discovered, push node onto queue.
*/
void RBT::printTree(Node* curr, queue<Node*>& discover) {
	printf("|%d,%d| ", curr->val, curr->color);

	if (discover.empty()) {
		return;
	}	
	
	if (curr->left) {
		discover.push(curr->left);
	} 
	
	if (curr->right) {
		discover.push(curr->right);
	}

	Node* next = discover.back();
	discover.pop();

	this->printTree(next, discover);
}

int main(){
	Node* root = new Node(7);
	RBT& tr = RBT();
	tr.insert(root);
	tr.printTree(root, queue<Node *>());
};