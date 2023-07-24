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
        // checks
        if(root == null) return 0;
        
        // Initialization
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;

        // Loop
        while(!queue.isEmpty()){
            // keep track of current level stats
            int size = queue.size();
            // level++;
            // process all current level nodes
            for(int i=0; i<size; i++){
                // poll out node
                TreeNode curr = queue.poll();

                // expand node
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }

            }
            level++;
        }

        // Finalize
        return level;

    }
}

/**
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
