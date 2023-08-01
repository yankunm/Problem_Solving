class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Initialize a min-heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // Loop each element in the array
        for(int x: nums){
            // Offer when heap has room or x is bigger than top
            if(heap.size() < k || x > heap.peek()){
                heap.offer(x);
            }
            // Poll if too many elements
            if(heap.size() > k){
                heap.poll();
            }
        }

        // Return the top element
        return heap.peek();
    }
}

/**

**Online Algorithm:**
-Scalable
-Dynamic - top of heap is always the k-th largest "SO FAR" (until this moment of processing)

Quickselect is an offline algorithm.

**High Level Idea:**
1. Initialize a min-heap
2. For each element x in the array:
    a. Offer to heap if heap has room or x is bigger than top element
    b. Adjust heap size if needed
3. Return the top of heap

 */
