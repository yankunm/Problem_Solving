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

    // Return tree depth in O(d) time
    // Follow the left-most edges till the end
    private int computeDepth(TreeNode root){
        int d = 0;
        while(root.left != null){
            root = root.left;
            d++;
        }
        return d;
    }

    // Imagine nodes at last level are numbered from 0 to 2^d - 1
    // Check if node with node with idx at the last level exists
    public boolean exists(int idx, int d, TreeNode node){
        int left = 0, right = (int) Math.pow(2, d) - 1;
        int pivot; // Compare with this to know whether traverse left or right 
        for(int i = 0; i < d; i++){
            pivot = left + (right - left) / 2; 
            if(idx <= pivot){
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    public int countNodes(TreeNode root) {
        // if tree is empty
        if(root == null) return 0;

        int d = computeDepth(root);

        // if the tree contains only 1 node
        if(d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2**d - 1
        // Perform binary search to check how many nodes exist
        int left = 1, right = (int) Math.pow(2, d) - 1;
        int pivot;
        while(left <= right){
            pivot = left + (right - left)/2;
            if(exists(pivot, d, root)) left = pivot + 1;
            else right = pivot - 1;
        }
        return (int) Math.pow(2, d) - 1 + left;  
    }
}

/**

 root
0    1 left

-------------
- exists(idx=4, d=3, node): left=0, right = 7
- i = 0: pivot = 3; node=node.right; left = 4
- i = 1: pivot = 5; node=node.left; right = 5
- i = 2: pivot = 4;
- if node in the end is null --> the node does not exist

Appraoch 2: Double Binary Search count the number of nodes in a complete binary tree

- computeDepth 1: d = 0; root -> left; d = 1; root -> left; d = 2

Approach 1: Recursively count the number of nodes in any binary tree

 public int countNodes(TreeNode root) {
        return root != null ? 1 + countNodes(root.left) + countNodes(root.right) : 0;
    }
 */
