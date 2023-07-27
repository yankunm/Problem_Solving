# 103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

__________________________________________________

High Level Idea:

1. Initialize queue with all entry points
2. Initialize boolean value leftToRight
3. while queue is not empty:
    a. get size
    SWITCH LEFTTORIGHT
    b. if leftToRight then initialize ArrayList
       else initialize LinkedList
    d. for all nodes in current level:
        -poll out element
        -if leftToRight then add else add(0, _)
        -expand node and offer to queue in-order
    e. add list to result
4. return result
