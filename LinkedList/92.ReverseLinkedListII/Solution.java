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

    // Object level variables since we need the changes
    // to persist across recursive calls and Java is pass by value.
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {

        // base case. Don't proceed any further
        if (n == 1) {
            return;
        }

        // Keep moving the right pointer one step forward until (n == 1)
        right = right.next;

        // Keep moving left pointer to the right until we reach the proper node
        // from where the reversal is to start.
        if (m > 1) {
            this.left = this.left.next;
        }

        // Recurse with m and n reduced.
        this.recurseAndReverse(right, m - 1, n - 1);

        // In case both the pointers cross each other or become equal, we
        // stop i.e. don't swap data any further. We are done reversing at this
        // point.
        if (this.left == right || right.next == this.left) {
            this.stop = true;            
        }

        // Until the boolean stop is false, swap data between the two pointers
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }
}

/**
Intuition 1: Recursion

Idea: Traverse down using recursion, connect back pointer based on whether the node is in range, the right node, or the left node


High Level Idea:
1. Base Case:   
    a. If this one or the next one is null then return 
    b. If right + 1 th node then store that and return
2. Call helper function to go to the next one, incrementing index
3. After returning from helper function:
    a. If this is the rightmost node
    b. If this is the leftmost node
    c. If this is just a node in range

 */
