#include <iostream>
#include <vector>

using namespace std;

class FrontMiddleBackQueue {
private:
    vector<int> queue;

public:
    FrontMiddleBackQueue() {}

    void pushFront(int val) {
        queue.insert(queue.begin(), val);
    }

    void pushMiddle(int val) {
        int mid = queue.size() / 2;
        queue.insert(queue.begin() + mid, val);
    }

    void pushBack(int val) {
        queue.push_back(val);
    }

    void print() {
        for (int num : queue) {
            cout << num << " ";
        }
        cout << endl;
    }

    int popFront() {
        if (queue.empty()) {
            return -1;
        }

        int font = queue.front();
        queue.erase(queue.begin());
        return font;
    }

    int popMiddle() {
        if (queue.empty()) {
            return -1;
        }

        int mid = (queue.size() - 1) / 2;
        int middle = queue[mid];
        queue.erase(queue.begin() + mid);
        return middle;
    }

    int popBack() {
        if (queue.empty()) {
            return -1;
        }

        int back = queue.back();
        queue.pop_back();
        return back;
    }
};

int main() {
    FrontMiddleBackQueue q;
    q.pushFront(1);
    q.pushBack(2);
    q.pushBack(3);
    q.pushBack(4);
    q.pushBack(5);
    q.pushBack(6);
    cout << q.popMiddle() << endl;
    q.print();

    return 0;

}
