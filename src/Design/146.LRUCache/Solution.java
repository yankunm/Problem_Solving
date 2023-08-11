
class LRUCache {

    /**
     * A node in a doubly linked list consisting of a key and a value,
     * and previous and next pointers.
     */
    private class ListNode {
 
        // Fields
        int key;
        int value;
        ListNode next;
        ListNode prev;

        // Constructors
        public ListNode(){
            key = 0;
            value = 0;
            next = null;
            prev = null;
        }

        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    // Fields
    private Map<Integer, ListNode> nodesTable; // For fast look up

    // Declare Doubly Linked List used for ranking of nodes
    private ListNode head;
    private ListNode tail;

    // Counter of elements to check if storage is full
    private int capacity;
    private int size;
    
    /**
     * Initialize fields
     */
    public LRUCache(int capacity) {
        // Initialize HashMap
        nodesTable = new HashMap<>();

        // Initialize DLL
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;

        // Initialize variables
        this.capacity = capacity;
        this.size = 0;
    }
    
    /**
     * Return the value of the key if the key exists, otherwise return -1
     */
    public int get(int key) {
        // checks
        if(size == 0) return -1;

        // If key exists in hashMap then
        if(nodesTable.containsKey(key)){
            // Extract listnode
            ListNode curr = nodesTable.get(key);
            // Move to end of DLL
            moveToEnd(curr);
            // Return value
            return curr.value;
        }
        return -1;
    }

    /**
     * Move node to the end of DLL
     */
    private void moveToEnd(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = this.tail;
        node.prev = this.tail.prev;
        this.tail.prev.next = node;
        this.tail.prev = node;
    }
    
    /**
     * Update the value of the key if the key exists. Otherwise, add the
     * key-value pair node to the cache. If the number of keys exceeds the
     * capacity then the LRU key will be evicted.
     * Node: When inserting and removing remember to do both map and DLL.
     */
    public void put(int key, int value) {
        // If key exists in hashMap then
        if(nodesTable.containsKey(key)){
            // Extract listnode
            ListNode curr = nodesTable.get(key);
            // Move to end of DLL
            moveToEnd(curr);
            // Replace value
            curr.value = value;
        } else {
            if(size >= capacity){
                // Remove oldest node from DLL and nodesTable
                poll();
                // Add new node to back of DLL and nodesTable
                offer(key, value);
            } else {
                offer(key, value);
            }
        }
    }

    /**
     * Remove the oldest node from DLL and nodesTable, and decrement size.
     * This function is only called when the number of nodes in cache reaches capacity.
     */
    private void poll(){
        // Remove head of DLL from nodesTable
        ListNode curr = head.next;
        nodesTable.remove(curr.key);

        // Remove curr from DLL
        head.next = curr.next;
        curr.next.prev = head;

        // Decrement size
        size--;
    }

    /**
     * Creates and add a new node with (key, value) to back of DLL and nodesTable,
     * and increment size
     */
    private void offer(int key, int value){
        // Create new ListNode
        ListNode curr = new ListNode(key, value);

        // Add new ListNode to DLL
        curr.prev = tail.prev;
        curr.next = tail;
        tail.prev = curr;
        curr.prev.next = curr;

        // Add new ListNode to nodesTable
        nodesTable.put(key, curr);

        // Increment size
        size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 /**
 
 Everything on paper:

 HashTable
 DLL

 DLL Definition:
    Beginning: least recently used
    End: most recently used

 DLL Operations:
    MoveToEnd [Used by Get when key exists]
    Offer [Used by Put when adding]
    Poll [Used by Put when capacity is full]

 Hash Table Definition:
    Key: Integer k of (k,v) pair
    Value: A node object of (k,v) pair

 LRUCache(capacity):
 1. Initialize Hash Table
 2. Initialize DLL
 3. Initialize capacity [how many objects are allowed]
 4. Initialize size [current number of objects]

 Get(key):
 1. If key exist in hashMap then
    a. move the node to end of DLL
    b. return value
 2. else if key dne then
    a. return -1

 Put(key, value):
 1. If key exist in hashMap then
    a. update v field of node to value
    b. move node to end back of linked list
 2. else if key does not exist then
    a. If the size >= capacity then
        i. Poll() from DLL and remove the key from hashMap
        ii. Put (key, value) node to back of DLL and add it to map
    b. If the size < capacity then
        i. put new node to back of DLL
        ii. Put new entry into hashmap
        iii. update size


    


  */
