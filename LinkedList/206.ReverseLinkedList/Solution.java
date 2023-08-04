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
    public ListNode reverseList(ListNode head){
        // Base Case
        if(head == null || head.next == null) return head;

        // Get Subproblem result to pass back
        ListNode reversedListHead = reverseList(head.next);

        // Do work at current level 
        head.next.next = head;
        head.next = null;
        
        // Pass back subproblem result
        return reversedListHead;
    }
}

/**
// Recursion

1. Get subproblem result
2. Do work at current level
3. return result

 */
