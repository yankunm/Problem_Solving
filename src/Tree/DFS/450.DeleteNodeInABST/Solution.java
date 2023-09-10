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

    public TreeNode deleteNode(TreeNode root, int key) {
        // Base Case
        if(root == null) return root;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        } else if(key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            // root is the node to delete
            if(root.left == null && root.right == null){
                return null;
            } else if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                // Both left child and right child aren't null
                // Find the successor
                TreeNode succ = root.right;
                while(succ.left != null){
                    succ = succ.left;
                }
                // Replace value of current node
                root.val = succ.val;
                // Delete successor from BST
                root.right = deleteNode(root.right, succ.val);
            }
        }

        // Finalize
        return root;
    }

}

/**

High Level Idea: 
1. Base case check (if null then return) - O(1)
2. If key < root.val then recursively update left subtree - O(h)
3. else if key > root.val then recursively update right substree - O(h)
4. else (we found it):
    a. If no children then return null - O(1)
    b. If left child is null then return right child - O(1)
    c. If right child is null then return left child - O(1)
    d. else (have both children)
        i. Find the minimum in the right subtree - O(h)
        ii. Set node value to that minimum - O(1)
        iii. Call deleteNode on that minimum node - O(h)

Time: O(h)
Space: O(1)

 */
