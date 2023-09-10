# 102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

__________________________________________________________


BFS General Steps:

Queue definition: store nodes that need expanding

1. Initialize queue with entry point
2. while queue is not empty:
    for each node in the queue in the current level
        poll it out, process it, expand it, offer to queue in-order
