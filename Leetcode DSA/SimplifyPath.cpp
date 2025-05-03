#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stack;
        stringstream ss(path);
        string token;

        while (getline(ss, token, '/')) {
            if (token == "" || token == ".") {
                continue; // Skip empty or current directory
            } else if (token == "..") {
                if (!stack.empty()) {
                    stack.pop_back(); // Go up one directory
                }
            } else {
                stack.push_back(token); // Add directory to stack
            }
        }
        string result = "/";
        for (const string& dir : stack) {
            result += dir + "/"; // Build the simplified path
        }
        if (result.size() > 1) {
            result.pop_back(); // Remove the trailing slash if not root
        }
        return result.empty() ? "/" : result; // Return root if empty
    }
};