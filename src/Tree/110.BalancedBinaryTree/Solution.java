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
    /**
     * Method for calculating the height of a tree
     */
    private int height(TreeNode root){
        if(root == null){
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // A tree is balanced iff the difference between the
    // left subtree's height and the right subtree's height
    // is not 2 or greater
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return (Math.abs(height(root.left) - height(root.right)) < 2) 
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
}

/**
height(3) = 2
- height(3): 1 + Math.max(height(9), height(20))
-- height(9): 1 + Math.max(height(null), height(null)) = 1 - 1 = 0
-- height(20): 1 + Math.max(height(15), height(7)) = 1
--- height(15): 1 - 1 = 0
--- height(7): 1 - 1 = 0
-- height(20): 1 + Math.max(0, 0) = 1
- height(3): 1 + Math.max(0, 1) = 1 + 1

 */
