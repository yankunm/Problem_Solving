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

    public boolean isSymmetric(TreeNode root){
        // only linkedlist allow insertion of null elements
        Queue<TreeNode> frontier = new LinkedList<>();
        frontier.offer(root.left);
        frontier.offer(root.right);

        while (!frontier.isEmpty()) {
            TreeNode n1 = frontier.poll();
            TreeNode n2 = frontier.poll();

            if(n1 == null && n2 == null){
                continue;
            }

            if (n1 == null || n2 == null){
                return false;
            }

            if (n1.val != n2.val){
                return false;
            } 

            frontier.offer(n1.left);
            frontier.offer(n2.right);
            frontier.offer(n1.right);
            frontier.offer(n2.left);
        }

        return true;
    }
}

/**

Approach 2: BFS by polling 2 at a time

We need to account for the difference between left and right.

For two nodes n1 and n2, Symmetric means:

n1.left == n2.right
n1.right == n2.left

1. Initialize Queue to store all entry points
2. While queue is not empty:
    -poll out two nodes, n1 and n2
    -if(one node is null) then return false
    -if(n1.val != n2.val) then return false
    -offer n1.left and n2.right
    -offer n1.right and n2.left
3. return true



Approach 1: BFS with help of Stack

THIS WOULD NOT WORK BC IT DOES NOT CHECK SYMMETRY.
It disregards left vs right.

        1
       / \
      2.  2
     /    /
    3    3

Find: a level where it's not a palindrome

1. Initialize queue with entry point
2. while queue is not empty:
    a. extract size of current level
    b. Initialize stack
    c. for each node in current level
        -poll it out
        -add it to stack if it is not same as top of stack
          else pop stack
        -expand node and offer to queue in-order 
    d. if stack is not empty then return false
3. return true

 */
