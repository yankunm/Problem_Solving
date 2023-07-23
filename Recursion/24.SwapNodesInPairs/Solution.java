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
    /**
     * Swaps Pairs using bottom-up recursion
     */
    public ListNode swapPairs(ListNode head) {
        
        // Base Case

        if(head == null || head.next == null){
            return head;
        }

        // Initialize Pointers
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Ask for result of subproblem
        firstNode.next = swapPairs(head.next.next);

        // Do work at current level of recursion
        secondNode.next = firstNode;

        // Return the result
        return secondNode;
    }
}


/**
Bottom-Up Recursion: 

1. Get subproblem result
2. Do work at current level
3. Return result

Top-Down Recursion:

1. Do work at current level
2. Recur down to the next level

1 --> 2

temp = head.next
head.next.next = head
head.next = temp.next

 */
