# Linked List

## Arrays vs Linked Lists

Arrays: <br>
* Search: O(1) Index Access <br>
* Insert At End: O(1) AMORTIZED <br>
* Delete: O(n) (move everything afterwards) <br>

Linked List: <br> 
* Search: O(n) scan whole list <br>
* Insert At End: O(n) (O(1) for doubly linked list) <br>
* Delete: O(n) *(Need to search for it first!!!)* <br>

## Two Pointers in Same Direction (60% Problems)

Two pointers point to nodes in the linked list, THEY MUST BE GOING IN SAME DIRECTION. <br>

Define: <br>
1. One fast One small, how far they separate <br>
2. Two pointers moving SPEED <br>

**Ex(1) Linked List find middle node**

Approach: Fast pointer go two nodes, Slow pointer go one node

  *When fast pointer reaches null, slow pointer points at middle.* --> **Floyd's Cycle Detection Algorithm**

*High Level Idea:*

1. Initialize 2 pointers i and j pointing to the head <br>
2. While the next move of the fast pointer j is valid (inside bound): <br>
        Move j two steps and i one step forward <br>
3. Return the node at i <br>

## Recursion

Call Stack -- first in last out. So if we need to go from back to head of linked list somehow, we can use (bottom-up) recursion.

**Most important for Recursion: BELIEVE that what you assume will absolutely happen, that your recursive function is definitely correct**

**Bottom-Up Recursion:** <br>
1. Get subproblem **result** <br>
2. Do something at current level <br>
3. return **result** <br>

The **result** for steps 1 and 3 must be consistent with each other.

**Ex(1) Reverse Linked List**

Reverse all REFERENCES in a linked list.

Step 1 for all recursion problems, lets assume everything before is already reversed except the node.

Everything follows from this assumption. Get the reversed part from subproblem. (*result*)

1 --> 2 --> 3 --> 4 --> 5

1 --> | reversed |

* make the next of the next node myself

1 <-- | reversed |

* make my next null

null <-- 1 <-- | reversed |

* return the reversed list (*result*)





















