#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_map<string, int> seen;
        vector<string> result;
        
        if (s.length() <= 10) return result;
        
        for (int i = 0; i <= s.length() - 10; i++) {
            string seq = s.substr(i, 10);
            seen[seq]++;
            if (seen[seq] == 2) {
                result.push_back(seq);
            }
        }
        
        return result;
    }
};