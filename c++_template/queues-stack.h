// Stacks and Queues Implementation Template
// Instructions: Implement the missing function definitions for each class.
// Each function has comments indicating what it should do.

#include <iostream>
#include <stdexcept>

//-------------------- ARRAY-BASED STACK --------------------
class ArrayStack {
private:
    int* array;
    int capacity;
    int top;

public:
    // Constructor: Initialize array with given size, set top to -1
    ArrayStack(int size = 100) {
        // TODO: Implement constructor
        capacity = size;
        array = new int[size];
        top = -1;
    }

    // Destructor: Free dynamically allocated memory
    ~ArrayStack() {
        // TODO: Implement destructor
        delete[] array;
    }

    // Returns true if stack has no elements, false otherwise
    bool isEmpty() {
        // TODO: Implement isEmpty function
        return top == -1; // Placeholder, replace with correct implementation;
    }

    // Returns true if stack is full, false otherwise
    bool isFull() {
        // TODO: Implement isFull function
        return top == capacity - 1; // Placeholder, replace with correct implementation
    }

    // Add value to the top of the stack
    // Should throw overflow_error if stack is full
    void push(int value) {
        // TODO: Implement push function
        if (isFull()) {
            throw std::underflow_error("Stack is full");
        }
        top++;
        array[top] = value;
    }

    // Remove and return the top element
    // Should throw underflow_error if stack is empty
    int pop() {
        // TODO: Implement pop function
        if (isEmpty()) {
            throw std::underflow_error("Stack is empty");
        }
        return array[top--];
    }

    // Return the top element without removing it
    // Should throw underflow_error if stack is empty
    int peek() {
        // TODO: Implement peek function
        if (isEmpty()) {
            throw std::underflow_error("Stack is emty");
        }
        return array[top];
    }

    // Return the number of elements in the stack
    int size() {
        // TODO: Implement size function
        return top + 1;
    }
};

//-------------------- ARRAY-BASED QUEUE --------------------
class ArrayQueue {
private:
    int* array;
    int capacity;
    int front;  
    int rear;
    int count;

public:
    // Constructor: Initialize array with given size
    // Set front to 0, rear to -1, and count to 0
    ArrayQueue(int size = 100) {
        // TODO: Implement constructor
        capacity = size;
        array = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Destructor: Free dynamically allocated memory
    ~ArrayQueue() {
        // TODO: Implement destructor
        delete[] array;
    }

    // Returns true if queue has no elements, false otherwise
    bool isEmpty() {
        // TODO: Implement isEmpty function
        return count == 0; // Placeholder, replace with correct implementation
    }

    // Returns true if queue is full, false otherwise
    bool isFull() {
        // TODO: Implement isFull function
        return count == capacity; // Placeholder, replace with correct implementation
    }

    // Add value to the end of the queue
    // Should throw overflow_error if queue is full
    // Remember to use circular array concept with modulo (%)
    void enqueue(int value) {
        // TODO: Implement enqueue function
        if (isFull()) {
            throw std::underflow_error("Queue is full");
        }
        rear = (rear + 1) % capacity;
        array[rear] = value;
        count++;
    }

    // Remove and return the front element
    // Should throw underflow_error if queue is empty
    // Remember to use circular array concept with modulo (%)
    int dequeue() {
        // TODO: Implement dequeue function
        if (isEmpty()) {
            throw std::underflow_error("Queue is empty");
        }
        int value = array[front];
        front = (front + 1) % capacity;
        count--;
        return value;
    }

    // Return the front element without removing it
    // Should throw underflow_error if queue is empty
    int peek() {
        // TODO: Implement peek function
        if (isEmpty()) {
            throw std::underflow_error("Queue is empty");
        }
        return array[front];
    }

    // Return the number of elements in the queue
    int size() {
        // TODO: Implement size function
        return count; // Placeholder, replace with correct implementation
    }
};

//-------------------- NODE CLASS FOR LINKED LISTS --------------------
class Node {
public:
    int data;
    Node* next;

    // Constructor: Initialize node with given value and set next to nullptr
    Node(int value) : data(value), next(nullptr) {}
};

//-------------------- LINKED LIST-BASED STACK --------------------
class LinkedListStack {
private:
    Node* top;
    int count;

public:
    // Constructor: Initialize top to nullptr and count to 0
    LinkedListStack() {
        // TODO: Implement constructor
        top = nullptr;
        count = 0;
    }

    // Destructor: Free all dynamically allocated nodes
    ~LinkedListStack() {
        // TODO: Implement destructor
        while (top != nullptr) {
            Node* temp = top;
            top = top->next;
            delete temp;
        }
        count = 0;
    }

    // Returns true if stack has no elements, false otherwise
    bool isEmpty() {
        // TODO: Implement isEmpty function
        return count == 0; // Placeholder, replace with correct implementation
    }

    // Add value to the top of the stack
    // Create a new node and make it the new top
    void push(int value) {
        // TODO: Implement push function
        Node* newNode = new Node(value);
        newNode->next = top;
        top = newNode;
        count++;
    }

    // Remove and return the top element
    // Should throw underflow_error if stack is empty
    int pop() {
        // TODO: Implement pop function
        if (isEmpty()) {
            throw std::underflow_error("Stack is empty");
        }
        Node* temp = top;
        int value = top->data;
        top = top->next;
        delete temp;
        count--;
        return value;
    }

    // Return the top element without removing it
    // Should throw underflow_error if stack is empty
    int peek() {
        // TODO: Implement peek function
        if (isEmpty()) {
            throw std::underflow_error("Stack is empty");
        }
        return top->data;
    }

    // Return the number of elements in the stack
    int size() {
        // TODO: Implement size function
        return count; // Placeholder, replace with correct implementation
    }
};

//-------------------- LINKED LIST-BASED QUEUE --------------------
class LinkedListQueue {
private:
    Node* front;
    Node* rear;
    int count;

public:
    // Constructor: Initialize front and rear to nullptr and count to 0
    LinkedListQueue() {
        // TODO: Implement constructor
        front = nullptr;
        rear = nullptr;
        count = 0;
    }

    // Destructor: Free all dynamically allocated nodes
    ~LinkedListQueue() {
        // TODO: Implement destructor
        while (front != nullptr) {
            Node* temp = front;
            front = front->next;
            delete temp;
        }
        rear = nullptr;
        count = 0;
    }

    // Returns true if queue has no elements, false otherwise
    bool isEmpty() {
        // TODO: Implement isEmpty function
        return count == 0; // Placeholder, replace with correct implementation
    }

    // Add value to the end of the queue
    // Special case: if queue is empty, front and rear both point to new node
    void enqueue(int value) {
        // TODO: Implement enqueue function
        Node* newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear->next = newNode;
        }
        rear = newNode;
        count++;
    }

    // Remove and return the front element
    // Should throw underflow_error if queue is empty
    // Special case: if queue becomes empty, set both front and rear to nullptr
    int dequeue() {
        // TODO: Implement dequeue function
        if (isEmpty()) {
            throw std::underflow_error("Queue is empty");
        }
        Node* temp = front;
        int value = front->data;
        front = front->next;
        delete temp;
        count--;
        if (isEmpty()) {
            rear = nullptr;
        }
        return value;
    }
    // Return the front element without removing it
    // Should throw underflow_error if queue is empty
    int peek() {
        // TODO: Implement peek function
        if (isEmpty()) {
            throw std::underflow_error("Queue is empty");
        }
        return front->data;
    }

    // Return the number of elements in the queue
    int size() {
        // TODO: Implement size function
        return count; // Placeholder, replace with correct implementation
    }
};

//-------------------- TESTING FUNCTION --------------------
// This function will test your implementation
// Do not modify this function!
void testStacksAndQueues() {
    // Test ArrayStack
    std::cout << "Testing Array-based Stack:\n";
    ArrayStack arrStack(5);
    
    try {
        for (int i = 1; i <= 5; i++) {
            arrStack.push(i * 10);
            std::cout << "Pushed: " << i * 10 << std::endl;
        }
        
        std::cout << "Stack size: " << arrStack.size() << std::endl;
        std::cout << "Top element: " << arrStack.peek() << std::endl;
        
        while (!arrStack.isEmpty()) {
            std::cout << "Popped: " << arrStack.pop() << std::endl;
        }
        
        // This should throw an underflow exception
        arrStack.pop();
    } catch (const std::underflow_error& e) {
        std::cout << "Expected exception: " << e.what() << std::endl;
    } catch (const std::overflow_error& e) {
        std::cout << "Expected exception: " << e.what() << std::endl;
    }
    
    // Test ArrayQueue
    std::cout << "\nTesting Array-based Queue:\n";
    ArrayQueue arrQueue(5);
    
    try {
        for (int i = 1; i <= 5; i++) {
            arrQueue.enqueue(i * 10);
            std::cout << "Enqueued: " << i * 10 << std::endl;
        }
        
        std::cout << "Queue size: " << arrQueue.size() << std::endl;
        std::cout << "Front element: " << arrQueue.peek() << std::endl;
        
        while (!arrQueue.isEmpty()) {
            std::cout << "Dequeued: " << arrQueue.dequeue() << std::endl;
        }
        
        // This should throw an underflow exception
        arrQueue.dequeue();
    } catch (const std::underflow_error& e) {
        std::cout << "Expected exception: " << e.what() << std::endl;
    } catch (const std::overflow_error& e) {
        std::cout << "Expected exception: " << e.what() << std::endl;
    }
    
    // Test LinkedListStack
    std::cout << "\nTesting Linked List-based Stack:\n";
    LinkedListStack llStack;
    
    for (int i = 1; i <= 5; i++) {
        llStack.push(i * 10);
        std::cout << "Pushed: " << i * 10 << std::endl;
    }
    
    std::cout << "Stack size: " << llStack.size() << std::endl;
    std::cout << "Top element: " << llStack.peek() << std::endl;
    
    while (!llStack.isEmpty()) {
        std::cout << "Popped: " << llStack.pop() << std::endl;
    }
    
    try {
        // This should throw an underflow exception
        llStack.pop();
    } catch (const std::underflow_error& e) {
        std::cout << "Expected exception: " << e.what() << std::endl;
    }
    
    // Test LinkedListQueue
    std::cout << "\nTesting Linked List-based Queue:\n";
    LinkedListQueue llQueue;
    
    for (int i = 1; i <= 5; i++) {
        llQueue.enqueue(i * 10);
        std::cout << "Enqueued: " << i * 10 << std::endl;
    }
    
    std::cout << "Queue size: " << llQueue.size() << std::endl;
    std::cout << "Front element: " << llQueue.peek() << std::endl;
    
    while (!llQueue.isEmpty()) {
        std::cout << "Dequeued: " << llQueue.dequeue() << std::endl;
    }
    
    try {
        // This should throw an underflow exception
        llQueue.dequeue();
    } catch (const std::underflow_error& e) {
        std::cout << "Expected exception: " << e.what() << std::endl;
    }
}
