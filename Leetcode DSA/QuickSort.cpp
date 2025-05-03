#include <iostream>
#include <vector>

using namespace std;

int partition(vector<int> &arr, int left, int right) {
    int pivot = arr[right];
    int i = left - 1;
    int j=left;
    while(j<right){
        if(arr[j]<pivot){
            i++;
            swap(arr[i],arr[j]);
        }
        j++;
    }
    
    swap(arr[i + 1], arr[right]);
    return i + 1;
}

void quickSort(vector<int> &arr, int left, int right) {
    if (left < right) {
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
}

int main() {
    vector<int> arr = {5, 4, 3, 2, 1};
    quickSort(arr, 0, arr.size() - 1);
    for (int i = 0; i < arr.size(); i++) {
        cout << arr[i] << " ";
    }

    return 0;
}