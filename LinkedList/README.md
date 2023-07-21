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

1 --> 2 --> 3 --> 4 --> null
            i <br>
                         j <br>

1 --> 2 --> 3 --> 4 --> 5 --> null
            i <br>
                               j <br>








