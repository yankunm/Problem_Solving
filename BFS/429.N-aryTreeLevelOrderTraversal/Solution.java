/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        // check
        if(root == null) return res;

        // Initialize
        Deque<Node> frontier = new ArrayDeque<>();
        frontier.add(root);
        
        // Loop each level of the tree
        while(!frontier.isEmpty()){
            // Record current level stats
            int size = frontier.size();

            // Initialize storage list for this level
            List<Integer> level = new ArrayList<>();

            // Loop each node in this level
            for(int i=0; i<size; i++){
                // Poll out element
                Node curr = frontier.poll();

                // Process element
                level.add(curr.val);

                // Expand element
                for(Node n: curr.children){
                    frontier.offer(n);
                }
            }

            // Add this level to res
            res.add(level);
        }

        // Finalize
        return res;
    }
}

/**
BFS High Level Idea:

Loop over each level of tree in-order and output traversal route.

1. Initialize Queue with Entry Point
2. While Queue is not Empty:
    a. Record current level stats
    b. Initialize a List for this Level
    c. Loop over each node in current level
        1. Poll out element
        2. Put that element val into level list
        3. Expand element
    d. Add level list to res list
3. Return res list


 */
