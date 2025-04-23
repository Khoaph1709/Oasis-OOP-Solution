#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int evalRPN(std::vector<std::string>& tokens) {
        vector<int> stack;

        for (const string& token : tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                int operand2 = stack.back();
                stack.pop_back();
                int operand1 = stack.back();
                stack.pop_back();

                int result;
                if (token == "+") {
                    result = operand1 + operand2;
                }
                else if (token == "-") {
                    result = operand1 - operand2;
                } else if (token == "*") {
                    result = operand1 * operand2;
                } else if (token == "/") {
                    result = operand1 / operand2;
                } else {
                    return -1;
                }

                stack.push_back(result);
            }
            else {
                stack.push_back(stoi(token));
            }
        }
        return stack.back();
    }
};