# 938. Range Sum of BST

Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

__________________________________________________________

Intuition 1: Pre-order traversal

Perform pre-order traversal on the binary tree. Find all nodes with wanted value and add them together.

Time: O(n)
Space: O(n) worst Case

This approach does not take advantage that the binary tree is a Binary Search Tree.
__________________________________________________________

Approach 1: Recursive DFS

1. if nodes value falls within range: add that to sum
2. if nodes value is too high: dfs on the left side
3. if nodes value is too low: dfs on the right side




