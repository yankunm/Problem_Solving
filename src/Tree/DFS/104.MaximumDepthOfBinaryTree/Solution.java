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
    public int maxDepth(TreeNode root) {
        // Base Case
        if(root == null) return 0;

        // Get Sub-problem answer
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Construct current level solution
        int solution = Math.max(leftDepth, rightDepth) + 1;

        // Pass solution to parent / user
        return solution;
    }
}

/**
Approach 3: DFS

High Level Idea:

1. Base Case
    -if(root == null) return 0
2. Get sub-problem answer
    leftDepth := maxDepth(root.left)
    rightDepth := maxDepth(root.right)
3. Use sub-problem answers to construct current solution
    solution := Math.max(leftDepth, rightDepth) + 1
4. Return solution to parent



Approach 2: BFS

[3, 9, 20, null, null, 15, 7]

High Level Idea:

if(root == null) return 0
Initialize Queue
queue.offer(root)
initialize level counter = 1
while queue is not empty: 
    // keep track of current level stats
    // Process current level
        // poll out node
        // expand it
        // offer to queue
    // level += 1
return level

    
    


Approach 1: Recursive

public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return java.lang.Math.max(leftHeight, rightHeight) + 1;
        }
        
    }


 */
