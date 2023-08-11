# 124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

_________________________________________________________________

Return: the maximum root-to-leaf path sum of current level

High Level Idea:

1. Base Case
2. Get Answers from Sub-Problems

    -leftSum = the root-to-leaf path sum of left subtree
    -rightSum = the root-to-leaf path sum of right subtree

3. Construct current level solution

    -maxSum = max(leftSum, rightSum, 0) + curr.val

4. Update global value

    -currPathSum = max(left, 0) + max(right, 0) + curr.val
    -if currPathSum > globalPathSum then return globalPathSum

5. return maxSum to parent / user

answer is consistent with final return value --> check

So how do we return the globalPathSum in the end, since our current high level idea
for our function is returning "maxSum" NOT "globalPathSum"?

We wrap our high level idea in a function, which is a routine that updates globalPathSum correctly in the backend, and return to the user the ultimate result of globalPathSum.
