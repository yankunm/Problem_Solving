/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Initialization
        ListNode res = new ListNode();
        ListNode curr = res;

        // Initialize Min-Heap
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);

        // Add all entry points to heap
        for(ListNode head: lists){
            if(head != null) heap.offer(head);
        }

        // Loop each element in all linked lists
        while(!heap.isEmpty()){
            // Poll out the root
            ListNode top = heap.poll();

            // Add the root to res
            curr.next = top;
            curr = curr.next;

            // Offer next if exists
            if(top.next != null){
                heap.offer(top.next);
            }
        }

        // Finalize
        return res.next;
    }
}

/**

This is an online algorithm because linked list is like a stream.

High Level Idea;

1. Initialize Min-Heap with all entry points
2. While heap is not empty: O(n)
    a. Poll out the root O(log k)
    b. add it to res O(log k)
    c. offer its next if exists O(1)

Time: O(nlogk)
Space: O(n)

 */
