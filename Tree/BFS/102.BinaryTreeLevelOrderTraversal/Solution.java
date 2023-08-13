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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Initialization
        List<List<Integer>> res = new ArrayList<>();
        // check
        if(root == null){
            return res;
        }

        // BFS Initialization
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        // while there are still nodes to expand
        while(!queue.isEmpty()){
            // this level 
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // for all nodes in this level
            for(int i=0; i < size; i++){
                // poll it out
                TreeNode node = queue.poll();

                // process it
                level.add(node.val);

                // expand it
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

            // add current level to result
            res.add(level);
        }
        return res;
    }
}

/**
BFS General Steps:

Queue definition: store nodes that need expanding

1. Initialize queue with entry point
2. while queue is not empty:
    for each node in the queue in the current level
        poll it out, expand it, offer to queue in-order

 */
