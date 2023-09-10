# 257. Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.


---------------------------------------

Intuition: DFS

In the beginning, I test if root is empty or not. If the root does exist, I create a String and do dfs on one side. Everytime I do dfs, if that node is not null then I will concatenate to my String, which was passed in as an argument. And in java, a String is immutable so while recursing, the previous scope String's value will not be changed. 

1. Test if root is null
2. If first time, then I will just add it into a string, else i will concatenate a arrow infront of it then add it into the string. (convert int to String in Java with Integer.toString())
