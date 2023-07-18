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
    private boolean firstTime = true;
    private List<String> allPaths = new ArrayList<>();

    private void dfs(TreeNode root, String path){
        // Base Case
        if(root == null){
            return;
        }

        // Use [firstTime] to test if an Arrow is needed
        if(firstTime) path += Integer.toString(root.val);
        else path += "->" + Integer.toString(root.val);

        firstTime = false;

        dfs(root.left, path);
        dfs(root.right, path);
        if(root.left == null && root.right == null) allPaths.add(path);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        String path = "";
        dfs(root, path);
        return allPaths;
    }
}
