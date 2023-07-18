# 96. Unique Binary Search Trees

Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

_______________________________________________

Intuition 1: Left-Right-Left-Right

When you have just two nodes. The number could be on your left or on your right -- 2 ways
When you have three nodes. The subtree could be on your left or on your right or both. -- 5 ways

ways subtrees can be both = 1
subtree on left
subtree on right

Base case:

1. just two nodes -- 2 ways
2. three nodes -- 5 ways

When 1 is root node -- 2 ways
When 2 is root node -- 1 way
When 3 is root node -- 2 ways
why?
Because the right subtree has two nodes when 1 is root.
Because both the right subtree and left subtree has one node when 2 is root.
Because the left subtree has two nodes when 3 is root.
