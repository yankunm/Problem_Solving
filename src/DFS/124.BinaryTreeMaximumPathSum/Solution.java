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

    private int globalMax = Integer.MIN_VALUE;

    private int dfs(TreeNode node){
        // Base Case
        if(node == null) return 0;

        // Get Sub-Problem Answers
        int leftMaxRTLPathSum = Math.max(dfs(node.left), 0);
        int rightMaxRTLPathSum = Math.max(dfs(node.right), 0);

        // Construct current level root-to-leaf path sum
        int currMaxRTLPathSum = Math.max(leftMaxRTLPathSum, rightMaxRTLPathSum) + node.val;

        // Update Global Stored Value
        int currMax = leftMaxRTLPathSum + rightMaxRTLPathSum + node.val;
        globalMax = (currMax > globalMax) ? currMax : globalMax;  

        return currMaxRTLPathSum;
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalMax;
    }
}

/**

Return: the maximum root-to-leaf path sum of current level

High Level Idea:

1. Base Case
2. Get Answers from Sub-Problems

    -leftSum = the root-to-leaf path sum of left subtree
    -rightSum = the root-to-leaf path sum of right subtree

3. Construct current level solution

    -maxSum = max(leftSum, rightSum, 0) + curr.val

4. Update global value

    -currPathSum = max(left, 0) + max(right, 0) + curr.val
    -if currPathSum > globalPathSum then return globalPathSum

5. return maxSum to parent / user

answer is consistent with final return value --> check

So how do we return the globalPathSum in the end, since our current high level idea
for our function is returning "maxSum" NOT "globalPathSum"?

We wrap our high level idea in a function, which is a routine that updates globalPathSum correctly in the backend, and return to the user the ultimate result of globalPathSum.
 */
