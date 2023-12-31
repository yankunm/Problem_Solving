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

    private int sum = 0;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        // checks
        if(root == null) return 0;

        // Call dfs on the initial state
        dfs(root, low, high);

        // Finalize
        return sum;
    }

    private void dfs(TreeNode node, int low, int high){
        if(node == null) return;
        if(node.val >= low && node.val <= high) sum += node.val;
        if(node.val > low) dfs(node.left, low, high);
        if(node.val < high) dfs(node.right, low, high);
    }
}

/**
Given a binary search tree, find all nodes with a value within the interval [low, high] and return their sum.

Implement a DFS using stack.

1. Push root node onto stack
2. check if root node's value is within range (> low and < high)
3. if root node's value is too high (> low) push left child into stack
4. if root node's value is too low (< high) push right child into stack
5. repeat 1-4 until stack is empty
 */
