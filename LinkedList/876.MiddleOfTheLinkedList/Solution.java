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
    public ListNode middleNode(ListNode head) {

        // Initialization
        ListNode slow = head, fast = head;

        // Loop
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Finalize
        return slow;
    }
}

/**
Initialize two pointers i and j pointing to beginning
while j is not out of bounds:
    move j forward two steps and i one step
return i 
 */
