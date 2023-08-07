class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Initialize
        List<String> res = new LinkedList<>();

        // Construct Adjacency Heap Representation
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> edge: tickets){
            graph.computeIfAbsent(edge.get(0), k -> new PriorityQueue<>()).offer(edge.get(1));
        }

        // Call dfs on starting node
        dfs(graph, res, "JFK");
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, List<String> res, String src){
        // Get the heap associated with src
        PriorityQueue<String> minHeap = graph.getOrDefault(src, new PriorityQueue<>());

        // while src has neighbors, recurse down
        while(!minHeap.isEmpty()){
            dfs(graph, res, minHeap.poll());
        }

        // else add to beginning of list (reversed)
        res.add(0, src);
    }

}


/**

Approach: Post-order Traversal on Edges

Given a list of edges, perform DFS, and throw out / discard all edges that we traversed.

Notice the distinction between pre-order and post-order.

Pre-order means we arrive at a node, we do something, then we will move-on. This is the approach you utilized. You chose the optimal node at each stage to recurse down to, but then you discarded the other route and hit a deadend.

We should use post-order here. Recurse first, then process the current node.

By recursing first, we consider all possibilities first. After we considered all possibilities, tried all possibilities, then you process the current node.

BELIEVE YOUR RECURSION FUNCTION IS CORRECT.



1. Initialize result list (iterinary order)
2. Call dfs(result, map, current_city)
    a. For each nieghbor of current_city:
        1. Poll out neighbor from heap
        2. dfs(result, map, current_city)
    b. Append current_city to result
3. Return result in reverse order


HashMap Definition:

Map{k,v}: v is a heap containing all cities connected by a flight from city kProblem Modeling Mistake


FALSE APPROACH: Greedy picking the least to DFS everytime will not work. Bc the least lexicographic city to travel to may lead to a deadend, where another city could lead to a valid iterinary. 

Problem Modeling Mistake.

1. Initialize HashMap with Priority Queue as each list
2. Have a pointer initialized to JFK
3. While pointer is not null
    a. if pointer is not in hashMap then add that element to the result list and break
    b. poll out element from pointer(key) 's heap(value) in HashMap
    c. if element is null then break;
    d. else pointer points to that element
    e. add that element to the result list
4. Check if result list abide by constraints
5. Return result list


 */
