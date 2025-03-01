// BST and AVL Implementation Template
// Instructions: Implement the missing function definitions for each class.
// Each function has comments indicating what it should do.

#include <iostream>
#include <queue>

// Binary Search Tree Node
class Node {
public:
    int data;
    Node* left;
    Node* right;
    int height;  // For AVL Tree

    Node(int value) : data(value), left(nullptr), right(nullptr), height(1) {}
};

// Binary Search Tree Implementation
class BST {
private:
    Node* root;

    // TODO: Implement private helper functions
    Node* insertRec(Node* node, int value) {
        // TODO: Implement recursive insert
        if (!node) {
            return new Node(value);
        }
        if (value < node->data) {
            node->left = insertRec(node->left, value);
        } else {
            node->right = insertRec(node->right, value);
        }
        return node;
    }

    Node* findMin(Node* node) {
        // TODO: Implement find minimum node
        while (node && node->left) {
            node = node->left;
        }
        return node;
    }

    Node* deleteRec(Node* node, int value) {
        // TODO: Implement recursive delete
        if (!node) {
            return nullptr;
        }
        if (value < node->data) {
            node->left = deleteRec(node->left, value);
        } else if (value > node->data) {
            node->right = deleteRec(node->right, value);
        } else {
            if (!node->left) {
                Node* temp = node->right;
                delete node;
                return temp;
            } else if (!node->right) {
                Node* temp = node->left;
                delete node;
                return temp;
            }
            Node* temp = findMin(node->right);
            node->data = temp->data;
            node->right = deleteRec(node->right, temp->data);
        }
        return node;
    }

    void inorderRec(Node* node) {
        // TODO: Implement recursive inorder traversal
        if (node) {
            inorderRec(node->left);
            std::cout << node->data << " ";
            inorderRec(node->right);
        }
    }

    void clearRec(Node* node) {
        // TODO: Implement recursive clear
        if (node) {
            clearRec(node->left);
            clearRec(node->right);
            delete node;
        }
    }

public:
    BST() : root(nullptr) {}

    ~BST() {
        // TODO: Implement destructor
        clearRec(root);
    }

    void insert(int value) {
        // TODO: Implement insert
        root = insertRec(root, value);
    }

    void remove(int value) {
        // TODO: Implement remove
        root = deleteRec(root, value);
    }

    bool search(int value) {
        // TODO: Implement search
        Node* current = root;
        while (current) {
            if (value == current->data) {
                return true;
            } else if (value < current->data) {
                current = current->left;
            } else {
                current = current->right;
            }
        }
        return false;
    }

    void inorder() {
        // TODO: Implement inorder traversal
        inorderRec(root);  
        std::cout << std::endl;
    }
};

// AVL Tree Implementation
class AVLTree {
private:
    Node* root;

    int height(Node* node) {
        // TODO: Implement height calculation
        return node ? node->height : 0;
    }

    int getBalance(Node* node) {
        // TODO: Implement balance factor calculation
        return node ? height(node->left) - height(node->right) : 0;
    }

    Node* rightRotate(Node* y) {
        // TODO: Implement right rotation
        Node* x = y->left;
        Node* T2 = x->right;
        x->right = y;
        y->left = T2;
        y->height = 1 + std::max(height(y->left), height(y->right));
        x->height = 1 + std::max(height(x->left), height(x->right));
        return x;
    }

    Node* leftRotate(Node* x) {
        // TODO: Implement left rotation
        Node* y = x->right;
        Node* T2 = y->left;
        y->left = x;
        x->right = T2;
        x->height = 1 + std::max(height(x->left), height(x->right));
        y->height = 1 + std::max(height(y->left), height(y->right));
        return y;
    }

    Node* insertRec(Node* node, int value) {
        // TODO: Implement recursive AVL insert with balancing
        if (!node) {
            return new Node(value);
        }
        if (value < node->data) {
            node->left = insertRec(node->left, value);
        } else if (value > node->data) {
            node->right = insertRec(node->right, value);
        } else {
            return node;
        }
        node->height = 1 + std::max(height(node->left), height(node->right));
        int balance = getBalance(node);

        if (balance > 1 && value < node->left->data) {
            return rightRotate(node);
        }

        if (balance < -1 && value > node->right->data) {
            return leftRotate(node);
        }

        if (balance > 1 && value > node->left->data) {
            node->left = leftRotate(node->left);
            return rightRotate(node);
        }

        if (balance < -1 && value < node->right->data) {
            node->right = rightRotate(node->right);
            return leftRotate(node);
        }
        return node;
    }

    void inorderRec(Node* node) {
        // TODO: Implement recursive inorder traversal
        if (!node) {
            return;
        }
        inorderRec(node->left);
        std::cout << node->data << " ";
        inorderRec(node->right);
    }

    void clearRec(Node* node) {
        // TODO: Implement recursive clear
        if (node) {
            clearRec(node->left);
            clearRec(node->right);
            delete node;
        } else {
            return;
        }
    }

    bool isBalancedRec(Node* node) {
        if (!node) {
            return true;
        }
        int balance = getBalance(node);
        if (balance > 1 || balance < -1) {
            return false;
        }
        return isBalancedRec(node->left) && isBalancedRec(node->right);
    }

public:
    AVLTree() : root(nullptr) {}

    ~AVLTree() {
        // TODO: Implement destructor
        clearRec(root);
    }

    void insert(int value) {
        // TODO: Implement insert
        root = insertRec(root, value);
    }

    void inorder() {
        // TODO: Implement inorder traversal
        inorderRec(root);
        std::cout << std::endl;
    }

    bool isBalanced() {
        // TODO: Implement balance check
        return isBalancedRec(root);
    }
};

// Testing function - DO NOT MODIFY
void testTrees() {
    std::cout << "Testing Binary Search Tree:\n";
    BST bst;
    
    // Insert elements
    bst.insert(50);
    bst.insert(30);
    bst.insert(70);
    bst.insert(20);
    bst.insert(40);
    
    std::cout << "Inorder traversal: ";
    bst.inorder();
    
    std::cout << "Search 30: " << (bst.search(30) ? "Found" : "Not found") << std::endl;
    std::cout << "Search 90: " << (bst.search(90) ? "Found" : "Not found") << std::endl;
    
    bst.remove(30);
    std::cout << "After removing 30, inorder traversal: ";
    bst.inorder();

    std::cout << "\nTesting AVL Tree:\n";
    AVLTree avl;
    
    // Insert elements that would cause rotations
    avl.insert(10);
    avl.insert(20);
    avl.insert(30);
    avl.insert(40);
    avl.insert(50);
    
    std::cout << "Inorder traversal: ";
    avl.inorder();
    
    std::cout << "Is tree balanced? " << (avl.isBalanced() ? "Yes" : "No") << std::endl;
}

int main() {
    testTrees();
    return 0;
}