# Stack

Last-In-First-Out: look back at the IMMEDIATE past values.

## Using Past State

A stack is used to **save a past state, so we can use a past value to compute the current answer**.

For DP, we need to save ALL PAST STATES. It is possible for it to need any subproblem or past answer. So we would usually use *Arrays* or *Hash Tables* for DP.

For stacks, you can only peek/pop the last inserted element.

## Stack Principle

It is crucial, that when we use a stack, we define what it represents. 

e.g. A stack could store all values left of arr[i] in arr[] that is bigger than arr[i]

e.g. The past states of a function (Call Stack)

## Monotonic Stack

Monotically increasing/decreasing is a property of a stack that stems from how we define it.

This pattern deals with the "next larger/smaller" or "previous" type of problem.

Monotonic increasing means it never is constant, or is never decreasing, and vice-versa.

When an element is popped from a m0onotonic stack, it is never used again.

### Monotonic Increasing Stack

Keep on pushing the elements in the stack until it is on an element that is smaller than the stack’s top and when it reaches such a number, it keeps on popping the stack till the point where it is either empty or its top is smaller than its current element. Therefore all the elements in the stack are in increasing order from bottom to top.

### Monotonic Decreasing Stack

If we want to find the next greater element in an array, we can maintain a monotonic decreasing stack. This means that if an element is pushed onto the stack, any elements that are smaller than it are popped from the stack until the top element is greater than the new element. 

## The Deque Interface: ArrayDeque Class

A "deck" is a double-ended Queue.

Insert: offerFirst and offerLast
Remove: pollFirst and pollLast
Retreive: peekFirst and peekLast

Additional Methods: removeFirstOccurence and removeLastOccurence

ArrayDeque class Iterator is fail-fast: throws ConcurrentModificationException 

Most operations except bulk opeartions run in amortized O(1) time.



