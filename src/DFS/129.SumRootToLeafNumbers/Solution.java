/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int globalSum = 0;

    private void dfs(TreeNode node, int prevNum){
        // Construct current number from previous answer
        int currNum = prevNum*10 + node.val;

        // Pre-order Traversal
        // Update globalSum if leaf
        if(node.left == null && node.right == null){
            globalSum += currNum;
        } 
        // Recurse on sub-problems
        if(node.left != null) dfs(node.left, currNum);     
        if(node.right != null) dfs(node.right, currNum);
    }

    public int sumNumbers(TreeNode root) {
        // Base Case
        if(root == null) return 0;
        dfs(root, 0);
        return globalSum;
    }
}

/**
Approach 1: Top-Down DFS 

1. Base Case

if(node == null) return null
if(node.left == null && node.right == null) then
    global_sum += prev_num*10 + node.val

2. Use previous result to do work at current level of recursion

    curr_num = prev_num*10 + node.val

3. pass down the result

    if(node.left != null) dfs(node.left)
    if(node.right != null) dfs(node.right)

 */
