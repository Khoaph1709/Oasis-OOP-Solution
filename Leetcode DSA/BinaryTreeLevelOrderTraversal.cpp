#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (!root) return result;

        vector<TreeNode*> currentLevel = { root };

        while (!currentLevel.empty()) {
            vector<int> levelValues;
            vector<TreeNode*> nextLevel;

            for (TreeNode* node : currentLevel) {
                levelValues.push_back(node->val);
                if (node->left) nextLevel.push_back(node->left);
                if (node->right) nextLevel.push_back(node->right);
            }

            result.push_back(levelValues);
            currentLevel = nextLevel;
        }

        return result;
    }
};