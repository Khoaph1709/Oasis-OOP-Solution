#include <iostream>
#include <vector>

using namespace std;

void bublleSort(vector<int>& arr) {
    for (int i = 0; i < arr.size(); i++) {
        for (int j = i + 1; j < arr.size(); j++) {
            if (arr[i] > arr[j]) {
                swap(arr[i], arr[j]);
            }
        }
    }
}

void bubbleSort2(vector<int>& arr) {
    bool swapped = true;
    while (swapped) {
        swapped = false;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr[i], arr[i + 1]);
                swapped = true;
            }
        }
    }
}

int main() {
    vector<int> arr = {5, 2, 8, 1, 9};
    bubbleSort2(arr);
    for (int i = 0; i < arr.size(); i++) {
        cout << arr[i] << " ";
    }
    return 0;
}