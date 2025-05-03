#include <iostream>
#include <vector>

using namespace std;

void insertionSort(vector<int>& arr) {
    for (int i = 1; i < arr.size(); i++) {
        int j = i - 1;
        int key = arr[i];   
        while (j >= 0 && arr[j] > key) {
            swap(arr[j], arr[j + 1]);
            j--;
        }
       // arr[j + 1] = key;
    }
}


int main() {
    vector<int> arr = {5, 4, 3, 2, 1};
    insertionSort(arr);
    for (int i = 0; i < arr.size(); i++) {
        cout << arr[i] << " ";
    }
    return 0;
}