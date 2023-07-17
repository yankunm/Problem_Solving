# 110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.
Def(Height Balanced): A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

_______________________________________________

A tree T is not balanced iff there exists p in T s.t. |height(p.left) - height(p.right)| > 1

Approach 1: Top Down Recursion

1. Obtain height of a tree recursively
2. Compare two child subtree's heights
3. Recurse on each child subtree


