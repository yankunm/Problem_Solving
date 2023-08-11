/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Check
        if(head == null) return null;

        // Initialize HashMap
        HashMap<Node, Node> oldToNew = new HashMap<>();
        
        // Create New Nodes and put into HashMap
        Node curr = head;
        
        // create newHead
        Node newHead = new Node(curr.val);
            
        // Store (old node, new node) in hashMap
        oldToNew.put(curr, newHead);

        // Update traverser
        curr = curr.next;

        // For each node in the old list
        while(curr != null){
            // Create new node
            Node newNode = new Node(curr.val);
            
            // Store (old node, new node) in hashMap
            oldToNew.put(curr, newNode);

            // Update traverser
            curr = curr.next;
        }

        // Use mapping to draw pointers in the new list
        curr = head;
        while(curr != null){
            // Get corresponding nodes to connect
            Node newNode = oldToNew.get(curr);
            Node newNextNode = oldToNew.get(curr.next);
            Node newRandomNode = oldToNew.get(curr.random);

            // Connect nodes
            newNode.next = newNextNode;
            newNode.random = newRandomNode;

            // Update traverser
            curr = curr.next;
        }

        // Finalize
        return newHead;
    }
}

/**
Given: A linked list of length n with Random Pointers
Construct: A new linked list with exact same structure.

Assume Node implemented hashCode() and equals()

HashMap Definition:
    Key: Old Node Object Reference
    Value: New Node Object Reference

High Level Idea:
1. Initialize HashMap to maintain old-to-new correspondence, new list head
2. for each node in old list, create a new node and put into hashMap - O(n)
3. for each node in old list - O(n)
    a. Get the next node in the old list
    b. Get the random node in the old list
    c. Use hashMap to get the corresponding new current node, new next node, and new random node
    d. Point new current node to new next node and new random node
4. Return new list

Time: O(n)
Space: O(n)

 */
