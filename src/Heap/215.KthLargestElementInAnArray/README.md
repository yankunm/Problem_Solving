# 215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

## Max Heap O(n + klogn)

"Heapify" the array, and poll k times.

## Min Heap O(nlogk)

* Maintain a size k min heap
* Add element to min heap if greater than or equal to the top element, adjust size if necessary
* At the end top of heap is the kth largest

**Explanation:**

Make sure heap is k-sized. Since we are adding greater elements in the heap every time. At the end, the top of min heap is the smallest among elements in the heap, but it's greater than any other element in the array, which in other words: kth largest element in the array.

**High Level Idea:**
1. Initialize a min-heap
2. For each element x in the array:
    a. Offer to heap if heap has room or x is bigger than top element
    b. Adjust heap size if needed
3. Return the top of heap

