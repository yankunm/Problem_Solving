# 114. Flatten Binary Tree to Linked List (Medium)

Given the root of a binary tree, flatten the tree into a "linked list":

 - The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.

- The "linked list" should be in the same order as a pre-order traversal of the binary tree.

---------------------------------------------------------------------------------

Go to the left most child, make end pointer point there; when going back and processing middle, set end pointer's right child as your right child and make left child as your right child.
Make end pointer go to the right most child.


Use a traverser to keep track of the end of the linked list.


