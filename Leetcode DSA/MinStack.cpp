#include <iostream>

using namespace std;

class MinStack {
private:
    struct Node {
        int val;
        int min;
        Node* next;

        Node(int val, int min, Node* next) : val(val), min(min), next(next) {}
    };

    Node* head; // Pointer to the top of the stack
public:

    MinStack() {
        head = nullptr;
    }

    void push(int val) {
        if (head == nullptr) {
            head = new Node(val, val, nullptr);
        } else {
            int min = val < head->min ? val : head->min;
            head = new Node(val, min, head);
        }
    }

    void pop() {
        if (head != nullptr) {
            Node* temp = head;
            head = head->next;
            delete temp;
        } else {
            cout << "Stack is empty. Cannot pop." << endl;
        }
    }

    int top() {
        if (head!= nullptr) {
            return head->val;
        } else {
            return -1;
        }
    }

    int getMin() {
        if (head!= nullptr) {
            return head->min;
        } else {
            return -1;
        }
    }
};