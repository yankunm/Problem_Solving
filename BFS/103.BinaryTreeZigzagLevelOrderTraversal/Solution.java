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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Initialize
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> frontier = new ArrayDeque<>();
        boolean leftToRight = false;

        // BFS
        frontier.add(root);
        while(!frontier.isEmpty()){
            int size = frontier.size();
            List<Integer> level;
            // switch left to right
            leftToRight = leftToRight ? false : true;

            if(leftToRight)
                level = new ArrayList<>();
            else
                level = new LinkedList<>();

            // for all nodes in current level
            for(int i = 0; i < size; i++){
                // poll node
                TreeNode curr = frontier.poll();
                // process node
                if(leftToRight)
                    level.add(curr.val);
                else
                    level.add(0, curr.val);
                // expand node
                if(curr.left != null) frontier.add(curr.left);
                if(curr.right != null) frontier.add(curr.right);
            }
            res.add(level);
        }

        return res;
    }
}

/**
High Level Idea:

1. Initialize queue with all entry points
2. Initialize boolean value leftToRight
3. while queue is not empty:
    a. get size
    SWITCH LEFTTORIGHT
    b. if leftToRight then initialize ArrayList
       else initialize LinkedList
    d. for all nodes in current level:
        -poll out element
        -if leftToRight then add else add(0, _)
        -expand node and offer to queue in-order
    e. add list to result
4. return result


 */
