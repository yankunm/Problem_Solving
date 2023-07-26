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
    public List<Integer> rightSideView(TreeNode root) {
        // Initialize
        List<Integer> res = new ArrayList<>();

        // Check
        if(root == null) return res;

        // BFS
        Deque<TreeNode> frontier = new ArrayDeque<>();
        frontier.offer(root);

        // while there are nodes to expand
        while(!frontier.isEmpty()){
            int size = frontier.size();

            // traverse current level
            for(int i=0; i<size; i++){
                // poll out
                TreeNode curr = frontier.poll();

                // process it
                if(i == size - 1)
                    res.add(curr.val);

                // expand it in-order
                if(curr.left != null)
                    frontier.add(curr.left);
                if(curr.right != null)
                    frontier.add(curr.right);
            }
        }

        // Finalize
        return res;
    }
}

/**
Approach 1: BFS, only adding right child

0. Initialize res
1. Initialize queue
2. add entry point
3. while queue is not empty:
    a. get size of current level
    b. expand out node and traverse from left to right
    c. in the for loop, last iteration (i = size-1), add value to res
4. return res 

 */


