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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // check
        if(root == null) return res;

        // Initialize
        Deque<TreeNode> frontier = new ArrayDeque<>();
        frontier.offer(root);

        // Loop through each level of tree
        while(!frontier.isEmpty()){
            // Initialize current level vars
            int size = frontier.size();
            int max = Integer.MIN_VALUE;

            // Loop through each node in this level
            for(int i = 0; i < size; i++){
                // Poll out element
                TreeNode curr = frontier.poll();

                // Process element
                if(curr.val > max) max = curr.val;

                // Expand element
                if(curr.left != null) frontier.offer(curr.left);
                if(curr.right != null) frontier.offer(curr.right);
            }
            
            // Store current level max in res
            res.add(max);            
        }

        // Finalize
        return res;
    }
}

/**
High Level Idea:

1. Initialize res List
2. Initialize Queue with entry point
3. Loop through each level of tree:
    a. keep record of stats for this level
    b. Initialize storage variable "max"
    c. loop over each node in this level of tree:
        1. Poll out element
        2. Process element (if element is bigger than max then update max)
        3. Expand element
    d. add max into res List
4. Return res


 */
