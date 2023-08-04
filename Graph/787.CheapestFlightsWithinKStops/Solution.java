class Solution {

    // class Cell implements Comparable<Cell> {
    //     int val, price, steps;

    //     public Cell(int v, int p, int s){
    //         val = v;
    //         price = p;
    //         steps = s;
    //     }

    //     @Override
    //     public int compareTo(Cell c){
    //         return this.price - c.price;
    //     }
    // }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // Construct Adjacency List
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // Initialize
        int[] stops = new int[n]; // track minimum number of stops to reach each node
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});

        // Loop Assignment
        while (!minHeap.isEmpty()) {
            // Poll out node
            int[] curr = minHeap.poll();
            int val = curr[0];
            int price = curr[1];
            int steps = curr[2];
        
            // Traverse only when not previously traversed with less stops (More stops == longer distance, greedy approach)
            if (steps > stops[val] || steps > k + 1) {
                continue; // Skip nodes with more steps than k + 1
            }

            // Note that we've encountered this node
            stops[val] = steps;
        
            // Process it
            if (val == dst) return price;

            // Expand it if valid
            if (graph.containsKey(val)) {
                for (int[] next : graph.get(val)) {
                    minHeap.offer(new int[]{next[0], next[1] + price, steps + 1});
                }
            }
        }

        // Check globalMin
        return -1;
    }
}

/**

High Level Idea: <br>
1. Initialize Heap with starting city marked with cost = 0 <br>
2. While heap is not empty: <br>
    a. Poll out one node <br>
    b. If node.stop > k, skip it <br>
    c. If this is the destination node, return node.cost <br>
    d. For all its neighbors, offer them to heap with current node's cost + edge cost (flight cost) <br>

MEMORY LIMIT EXCEEDED:

class Cell implements Comparable<Cell> {
        int val, price, steps;

        public Cell(int v, int p, int s){
            val = v;
            price = p;
            steps = s;
        }

        @Override
        public int compareTo(Cell c){
            return this.price - c.price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Cell>> graph = new HashMap<>();


        // REMOVE K BECAUSE IT TAKES UP UNNECESSARY SPACE.
        // Construct Adjacency List
        for(int[] edge: flights){
            // Get arraylist of this key if has
            List<Cell> list = graph.getOrDefault(edge[0], new ArrayList<>()); 

            // Add to arraylist of this key this edge
            list.add(new Cell(edge[1], edge[2], 0));

            // Put the arraylist (back) into graph
            graph.put(edge[0], list);
        }

        // Initialize
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        int globalMin = -1;
        minHeap.offer(new Cell(src, 0, 0));

        // Loop Assignment
        while(!minHeap.isEmpty()){
            // Poll out node
            Cell curr = minHeap.poll();

            // Process it
            if(curr.val == dst){
                if(globalMin < 0){
                    globalMin = curr.price;
                } else {
                    globalMin = Math.min(globalMin, curr.price);
                }
                continue;
            }

            // Expand it if valid
            if(curr.steps <= k && graph.containsKey(curr.val)){
                for(Cell c: graph.get(curr.val)){
                    minHeap.offer(new Cell(c.val, c.price + curr.price, curr.steps + 1));
                }
            }
        }

        // Check globalMin
        return globalMin;
    }

Cell Definition:
Cell[0]: destination node label
Cell[1]: price to get there
Cell[2]: steps taken to get there

High Level Idea:
1. Construct Adjacency List
2. Initialize Heap to store Cell structures, global Min
3. while heap is not empty: 
    a. Poll out node
    b. if target reached then update globalMin
    c. else if not greather than k then expand node and offer neighbors
4. return global min

Build Intuition:

I want to find the shortest path from src to dst with at most k stops, meaning I can have 0 stops, 1 stop, 2 stop, and up and equal to k stops.

0 -> [(1, 100)] 
1 -> [(2, 100), (3, 600)]
2 -> [(0, 100), [3, 200]]
3 -> []

To go from 0 to 3, we have to start at 0, see which path cost the least to go next which is (1, 100), and we are at 1. Now we took 1 step, so we must go to 3 in 1 step. At 1, there is 3 with weight 600, so we record 600 + 100 as our cheapest price.

0 -> [(1, 100), (2, 500)] 
1 -> [(2, 100)]
2 -> []
3 -> []

 */
