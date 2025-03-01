//
// Created by letie on 2/22/2025.
//
#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include "LinkedList.h" 
#include "queues-stack.h"

using namespace std;

long long solveProblem1(vector<int>&arr){
    int n=arr.size();
    sort(arr.begin(),arr.end());
    int begin=0;
    long long ans=0;
    for(int i=0;i<arr.size();i++){
        if(i==0) continue;
        if(arr[i-1]!=arr[i]){
            int count=i-begin;
            begin=i;
            ans+= count*(count-1)/2;

        }
    }
    int count=n-begin;
    ans+= count*(count-1)/2;
    return ans;
}
void solveProblem2(vector<pair<string,pair<int,int>>>&inputs){
    SinglyLinkedList<int> List;
    for(auto& input:inputs){
        string command=input.first;
        int pos=input.second.first;
        int val=input.second.second;
        if(command=="insert") {
            try{
                List.insert(pos,val);
            }
            catch (std::out_of_range& a){
                cout<<"Expression: "<<a.what()<<endl;
                return;
            }
        }
        else if(command=="delete") List.remove(pos);
    }
    List.display();
}
void count_triplets(DoublyLinkedList<int>& List){
    if(List.size()<3) cout<<0;
    else{
        int count=0;
        DoublyLinkedList<int>::Node* it=List.get_head()->next;
        for(int i=0;i<List.size()-2;i++){
            int sum=(it->data)+(it->prev->data)+(it->next->data);
            if(sum==0) count++;
            it=it->next;
        }
        cout<<count;
        return;
    }

}
void solveProblem3(vector<int>&arr){
    DoublyLinkedList<int> List;
    for(auto v:arr){
        List.pushBack(v);
    }
    DoublyLinkedList<int>::Node* head=List.get_head();
    count_triplets(List);
    return ;
}
void solveProblem4(vector<pair<string,int>>&inputs){
    LinkedListQueue Q;
    for(auto& input:inputs){
        string command=input.first;
        int val=input.second;
        //cout<<command<<" "<<val<<endl;
        if(command=="enqueue") {
            try{
                Q.enqueue(val);
            }
            catch (std::out_of_range& a){
                cout<<"Expression: "<<a.what()<<endl;
                return;
            }
        }
        else if (command=="dequeue") Q.dequeue();
    }
    while(!Q.isEmpty()){
        cout<<Q.dequeue()<<" ";
    }
}
void solveProblem5(vector<pair<string,int>>&inputs){
    LinkedListStack S;
    for(auto& input:inputs){
        string command=input.first;
        int val=input.second;
        //cout<<command<<" "<<val<<endl;
        if(command=="push") {
            try{
                S.push(val);
            }
            catch (std::out_of_range& a){
                cout<<"Expression: "<<a.what()<<endl;
                return;
            }
        }
        else if (command=="pop") S.pop();
    }
    string s="";
    while(!S.isEmpty()){
        s=s+to_string(S.pop())+" ";
    }
    if(s.size()>0) s.pop_back();
    reverse(s.begin(),s.end());
    cout<<s;
}
void auto_tester(){
    //Test Problem 1
    vector<pair<int, vector<int>>> test_problem_1={
            {6,{5,2,4,2,2,5}},
            {1,{1}},
            {3,{1,2,3}},
            {3,{1,1,1}},
            {3,{2,3,3}}

    };
    vector<int> expected_output_problem_1={
            4,
            0,
            0,
            3,
            1
    };
    cout<<"-----------Problem 1--------------"<<endl;
    int cnt=0;
    for( auto& test:test_problem_1){
        cnt++;
        cout<<"Test "<<cnt<<endl<<"Expected Output: "<<expected_output_problem_1[cnt-1]<<endl<<"Output: "<<solveProblem1(test.second)<<endl<<endl;
    }

    //Test problem 2
    cout<<endl<<"-----------Problem 2--------------"<<endl;
    vector<pair<int, vector<pair<string, pair<int, int>>>>> test_problem_2{
            {5,{
                {"insert",{0,1}},
                {"insert",{1,3}},
                {"insert",{1,4}},
                {"insert",{2,2}},
                {"delete",{1,0}},
                }},
    };
    vector<string> expected_output_problem_2{
            "1 2 3"
    };
    cnt=0;
    for( auto& test:test_problem_2){
        cnt++;
        cout<<"Test "<<cnt<<endl<<"Expected Output: "<<expected_output_problem_2[cnt-1]<<endl<<"Output: ";
        solveProblem2(test.second);
        cout<<endl<<endl;
    }

    //Test Problem 3
    cout<<endl<<"-----------Problem 3--------------"<<endl;
    vector<pair<int,vector<int>>> test_problem_3{
            {6,{5,-3,-2,2,9,-11}}
    };
    vector<int> expected_output_problem_3{
            2
    };
    cnt=0;
    for( auto& test:test_problem_3) {
        cnt++;
        cout << "Test " << cnt << endl << "Expected Output: " << expected_output_problem_3[cnt-1]<< endl << "Output: ";
        solveProblem3(test.second);\
        cout << endl << endl;
    }
    //Test Problem 4
    cout<<endl<<"-----------Problem 4--------------"<<endl;
    vector<pair<int,vector<pair<string,int>>>> test_problem_4{
            {7,{
                {"enqueue",1},
                {"enqueue",2},
                {"enqueue",3},
                {"enqueue",4},
                {"dequeue",0},
                {"dequeue",0},
                {"enqueue",5}
            }}
    };
    vector<string> expected_output_problem_4{
            "3 4 5"
    };
    cnt=0;
    for( auto& test:test_problem_4) {
        cnt++;
        cout << "Test " << cnt << endl << "Expected Output: " << expected_output_problem_4[cnt-1]<< endl << "Output: ";
        solveProblem4(test.second);
        cout << endl << endl;
    }
    //Test Problem 5
    cout<<endl<<"-----------Problem 5--------------"<<endl;
    vector<pair<int,vector<pair<string,int>>>> test_problem_5{
            {7,{
                {"push",1},
                {"push",2},
                {"push",3},
                {"push",4},
                {"pop",0},
                {"pop",0},
                {"push",5}
            }}
    };
    vector<string> expected_output_problem_5{
            "1 2 5"
    };
    cnt=0;
    for( auto& test:test_problem_5) {
        cnt++;
        cout << "Test " << cnt << endl << "Expected Output: " << expected_output_problem_5[cnt-1]<< endl << "Output: ";
        solveProblem5(test.second);
        cout << endl << endl;
    }
}
void manual_tester(int problem_number) {
    //Test Problem 1
    if (problem_number == 1) {
        cout << "Problem 1\nEnter -1 to exit\n";
        while (true) {
            int n;
            cin >> n;
            if (n == -1) return;
            vector<int> arr(n);
            for (int i = 0; i < n; i++) {
                cin >> arr[i];
            }
            cout << solveProblem1(arr) << endl;
        }
    }

    //Test Problem 2
    if (problem_number == 2) {
        cout<<"Problem 2\nEnter -1 to exit\n";
        while (true){
        int m;
        cin >> m;
        if (m == -1) return;
        vector<pair<string, pair<int, int>>> inputs(m);
        for (int i = 0; i < m; i++) {
            string command;
            int pos, val;
            cin >> command;
            if (command == "insert") cin >> pos >> val;
            else {
                cin >> pos;
                val = 0;
            }
            inputs[i] = {command, {pos, val}};
        }
        solveProblem2(inputs);
        cout << endl;
        }
    }

    //Test Problem 3
    if (problem_number == 3) {
        cout << "Problem 3\nEnter -1 to exit\n";
        while(true) {

            int n;
            cin >> n;
            if (n == -1) return;
            vector<int> arr(n);
            for (int i = 0; i < n; i++) {
                cin >> arr[i];
            }
            solveProblem3(arr);
        }
    }
    //Test Problem 4
    if (problem_number == 4) {
        cout << "Problem 4\nEnter -1 to exit\n";
        while (true) {
            int m;
            cin >> m;
            if (m == -1) return;
            vector<pair<string, int>> inputs(m);
            for (int i = 0; i < m; i++) {
                string command;
                int val;
                cin >> command;
                if (command == "enqueue") {
                    cin >> val;
                    inputs[i] = {command, val};
                } else inputs[i] = {command, 0};
            }
            solveProblem4(inputs);
        }
    }

    //Test Problem 5
    if (problem_number == 5) {
        cout << "Problem 5\nEnter -1 to exit\n";
        while (true) {

            int m;
            cin >> m;
            if (m == -1) return;
            vector<pair<string, int>> inputs(m);
            for (int i = 0; i < m; i++) {
                string command;
                int val;
                cin >> command;
                if (command == "push") {
                    cin >> val;
                    inputs[i] = {command, val};
                } else inputs[i] = {command, 0};
            }
            solveProblem5(inputs);
        }
    }
}
int main(){
    auto_tester();
    manual_tester(1);
    manual_tester(2);
    manual_tester(3);
    manual_tester(4);
    manual_tester(5);
    return 0;
}