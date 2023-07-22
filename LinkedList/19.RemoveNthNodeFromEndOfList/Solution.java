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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize i and j n-apart
        ListNode i = head, j = head;
        for(int count = 0; count < n; count++){
            j = j.next;
        }

        // If we are deleting head
        if(j == null){
            return head.next;
        }

        // Traverse until appropriate
        while(j.next != null){
            i = i.next;
            j = j.next;
        }

        // delete appropriate node
        i.next = i.next.next;

        return head;
    }
}

/**
Approach 2: Two Pointers

High Level Idea:
1. Initialize i and j n apart
2. If j == null (after initilazation) return head.next because we are deleting head
3. while j.next != null
   traverse both pointers
4. i.next=i.next.next
5. return head


Approach 1: Two Pass

public ListNode removeNthFromEnd(ListNode head, int n) {
        // Count how many nodes are in linked list
        ListNode tr = head;
        if(tr == null) return null;
        int length = 0;

        // While tr is not null
        while(tr != null){
            length++;
            tr = tr.next;
        }
        
        // delete (length - n)-th node
        // go to the previous node
        tr = head;
        // Handle special case (first node we want to delete)
        if(length-n == 0){
            return head.next; 
        }
        // some middle or last node we want to delete
        for(int i = 0; i < (length-n)-1; i++){
            tr = tr.next;
        }
        // delete next node
        tr.next = tr.next.next;
        return head;
    }

 */
