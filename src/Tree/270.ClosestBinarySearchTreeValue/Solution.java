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

    // Traverse BST and store into [sortedArr]
    private void inorderTraversal(TreeNode root, List<Integer> sortedArr){
        if(root == null) return; 
        inorderTraversal(root.left, sortedArr);
        sortedArr.add(root.val);
        inorderTraversal(root.right, sortedArr);
    }

    public int closestValue(TreeNode root, double target) {
        // Intialize
        List<Integer> sortedArr = new ArrayList<>();

        // convert BST to a sorted array
        inorderTraversal(root, sortedArr);

        // Sequential Scan sorted array to find closest value to target
        // Minimize the difference between a node's value and the target
        return Collections.min(sortedArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });

    }

    
}

/**
Approach 1: Recursive Preorder Traversal (My Approach)
1. Traverse the tree starting from root, Keep track of closestValue
2. Update closestValue if:
    Math.abs(current.val - target) < Math.abs(closestValue - target)
3. Traverse until null and return

private int closestVal;

    // traverses the tree recursively and updates the closestVal
    private void preorderTraversal(TreeNode node, double target){
        if(node == null){
            return;
        }
        if(Math.abs(node.val - target) < Math.abs(closestVal - target)){
            closestVal = node.val;
        } else if(Math.abs(node.val - target) == Math.abs(closestVal - target)){
            closestVal = node.val < closestVal ? node.val : closestVal;
        } 
        preorderTraversal(node.left, target);
        preorderTraversal(node.right, target);
    }

    public int closestValue(TreeNode root, double target) {
        closestVal = root.val;
        preorderTraversal(root, target);
        return closestVal;
    }

Approach 2: Recursive Inorder + Linear search
1. Traverse the tree starting from root, convert it to a sorted array using inorder traversal
2. Linear Search in sorted array to find the closest Value (Math.min) fun


 */
