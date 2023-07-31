# Heap

Heap is a *Complete Binary Tree* constructed using an array. The **root** of the tree is either the maximum element (max heap) or the minimum element (min heap). **Heap is most commonly used for "Top k" problems**.

**Common APIs:**
* peek(): Return at top element in heap (O(1))
* poll(): Remove top element in heap (O(log n))
* offer(): Insert element (O(log n))

## Online Algorithm (usually Heap)

Work with streams, **no fixed size**, scalable.

## Min Heap O(nlogk)
* Maintain a size k min heap 
* Add element to min heap if greater than or equal to the top element, adjus    t size if necessary
* At the end top of heap is the kth largest 

**Explanation:**

Make sure heap is k-sized. Since we are adding greater elements in the heap every time. At the end, the top of min heap is the smallest among elements in the heap, but it's greater than any other element in the array, which in other words: kth largest element in the array.

## Offline Algorithm (Sorting)

Work with **fixed length** data, has to be reused after every scaling.


