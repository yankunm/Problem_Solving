# 222. Count Complete Tree Nodes (Medium)

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

-----------------------------------------------------------------------------------

Approach 1: Count nodes recursively

1. return 1 + recurse on left + recurse on right
	Stop when reached null

this works because every node activates the "1 +".

Time: O(n)
Space: O(log n)

-----------------------------------------------------------------------------------

Approach 2: Binary Search with in Binary Search

Complete binary tree, k-th level has 2^k nodes except the last one.
Let the depth of the binary tree be d, then the last level could have 1 to 2^d number of nodes.

The sum of all nodes in all levels except the last one is 
the Sum of 2^k as k goes from 0 to d - 1, which is 2^(d-1) + 2^(d-2) + ... + 2 + 1.
The sum of a geometric series is (a(r^n - 1))/(r - 1), which is 2^d - 1 in our case.

So,

The total number of nodes = 2^d - 1 + number of nodes at level d

Using binary search, we can check the existence of nodes in last level in log(2^d) which is O(d) time.
If we enumerate the nodes in the last level, then to check any one node's existence from the root
we can see that it takes another O(d) time. So to get the total number of nodes, we have to take O(d*d) time,
which is O(log^2 n).

1. Compute d
2. Use exists method to use binary search down the tree to see if a node exists
3. Use Binary Search in main method to repeat calling exists until left crosses right - left points at first nonexistent leaf node.



