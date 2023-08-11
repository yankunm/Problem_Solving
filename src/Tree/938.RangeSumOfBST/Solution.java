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
        if(root != null){
            if(root.val >= low && root.val <= high){
                sum += root.val;
            }
            if(low < root.val){
                rangeSumBST(root.left, low, high);
            }
            if(high > root.val){
                rangeSumBST(root.right, low, high);
            }
        }
        return sum;
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
