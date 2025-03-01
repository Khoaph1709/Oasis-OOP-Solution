#include <bits/stdc++.h>
#include "LinkedList.h"
#include "sorting.h"
#include "queues-stack.h"

using namespace std;

void Solve1() {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    if (n < 2) {
        cout << 0 << endl;
        return;
    }

    int count = 1;
    int total = 0;

    SortingAlgorithms::quickSort(a);

    for (int i = 0; i < n - 1; i++) {
        if (a[i] == a[i + 1]) {
            count++;
        } else {
            total += count * (count - 1) / 2;
            count = 1;
        }
    }

    total += count * (count - 1) / 2;

    cout << total << endl;
}


int main() {
    // Solve1();
    int n;
    cin >> n;
    DoublyLinkedList<int> list;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        list.pushBack(x);
    }

    cout << list.countTriplets() << endl;
    return 0;
}