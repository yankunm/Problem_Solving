# 19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

_______________________________________________________

1. Model the problem

This is a linked list traversal/searching problem. We are searching the n-th node from the end of the list.

2. Build Intuition

1 --> 2 --> 3 --> 4 --> 5 --> null   n = 2
                  i
1 --> 2 --> 3 --> 5 --> null

1 --> null  n = 1
null

3. Use drawings to come up with solution

1 --> 2 --> 3 --> null n=2
j     j     j      j
      <------> 2

<------------> 3

<----> 1
j = 3 - 2 = 1

4. Develop high level idea

1. Count how many nodes are in linked list
2. traverse length - n times and delete that node

5. Code it out

6. Seek Improvement
Could you do it in one pass?

____________________________________________________________

Approach 2: Two Pointers with Linked Lists

We define:

1. Distance - n
2. Speed - same

Separate two pointers with distance n before hand, then move until the first hits null.

[1, 2, 3, 4, 5] n=2
          i     j

[1, 2, 3, 4, 5] n=5
 i              j

move until j or j.next == null

[1] null
 i  j

1. Initialize i and j n apart
2. If j == null (after initilazation) return head.next because we are deleting head
3. while j.next != null
  traverse both pointers
4. i.next=i.next.next
5. return head

[1, 2] n = 2
 i     j



                  

