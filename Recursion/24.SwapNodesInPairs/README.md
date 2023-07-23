# 24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

________________________________________________________________

1. Read and Model the problem
2. Draw and build intuition
3. Write out high level idea
4. Implement in code
5. Analyze Time and Space Complexities

________________________________________________________________

1 --> 2 --> 3 --> 4 

2 --> 1 --> 4 --> 3

Intuition 1: Top-Down Recursion

return head;

1. Get the result of the subproblem

head.next = swapPairs(head.next.next);

2. Do work at current level

secondnode.next = head;

3. return result

return head;
