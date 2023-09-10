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
    public TreeNode searchBST(TreeNode root, int val) {
        // Base Case
        if(root == null) return null;
        
        // traverse left
        if(val < root.val){
            return searchBST(root.left, val);
        } else if(val > root.val){ // traverse right
            return searchBST(root.right, val);
        } else { // equal
            return root;
        }
    }
}
