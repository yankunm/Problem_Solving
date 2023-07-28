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
    public int minDepth(TreeNode root) {
        // checks
        if(root == null) return 0;

        // Initialize
        Deque<TreeNode> frontier = new ArrayDeque<>();
        int depth = 0;
        frontier.offer(root);

        // BFS Loop all levels
        while(!frontier.isEmpty()){
            // Record current level stats
            int size = frontier.size();
            // Increment depth before processing current level
            depth++;
            // Loop over current level nodes
            for(int i=0; i<size; i++){
                
                // Poll out element
                TreeNode curr = frontier.poll();

                // Process element
                if(curr.left == null && curr.right == null){
                    return depth;
                }

                // Expand element
                if(curr.left != null){
                    frontier.offer(curr.left);
                }
                if(curr.right != null){
                    frontier.offer(curr.right);
                }
            }
        }
        return 0;
    }
}

/**
Shortest path in an unweighted graph --> BFS

 */
