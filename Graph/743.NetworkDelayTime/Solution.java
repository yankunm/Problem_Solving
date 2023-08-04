class Solution {

    class EdgeNode implements Comparable<EdgeNode>{
        // Each node has the destination node and time to get there
        int node, time;

        // Constructor
        public EdgeNode(int n, int t){
            node = n;
            time = t;
        }

        // Implement Comparable
        @Override
        public int compareTo(EdgeNode n){
            return this.time - n.time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // Construct Adjacency List
        HashMap<Integer, List<EdgeNode>> graph = new HashMap<>();
        for(int[] edge: times){
            List<EdgeNode> thisEdgeList = graph.getOrDefault(edge[0], new ArrayList<>());
            thisEdgeList.add(new EdgeNode(edge[1], edge[2]));
            graph.put(edge[0], thisEdgeList);
        }

        // Initialize
        HashMap<Integer, Integer> visitTimes = new HashMap<>();
        PriorityQueue<EdgeNode> minHeap = new PriorityQueue<>();
        
        // Put starting point into minHeap
        minHeap.offer(new EdgeNode(k, 0));

        // Loop until processed every node and every edge
        while(!minHeap.isEmpty()){
            // Poll out edge node
            EdgeNode curr = minHeap.poll();

            // If visited then skip it
            if(visitTimes.containsKey(curr.node)) continue;

            // Put into table
            visitTimes.put(curr.node, curr.time);

            // Put all neighbors of curr.node into heap
            if(graph.containsKey(curr.node)){
                for(EdgeNode neighbor: graph.get(curr.node)){
                    // if unvisited
                    minHeap.offer(new EdgeNode(neighbor.node, neighbor.time + curr.time));
                }
            }
        }

        // Check if traversed n nodes
        if(visitTimes.size() != n) return -1;
        
        // Scan visitTimes and find maximum
        int maxTime = -1;
        for(int t: visitTimes.values()){
            maxTime = t > maxTime ? t : maxTime;
        }

        // Finalize
        return maxTime;


    }
}

/**

Since I want to find the shortest path to some node, I will record nodes and the amount of distance traveled to get to them as soon as I encounter them. This way, in the end, I can query for the maximum distance, and it will be the shortest path distance to this FURTHEST NODE.

So I use the logic of me "storing as soon as encountered" to automatically store only shortest paths. And my goal is to find the longest path among all shortest paths, because the longest means the furthest, that will be my limiting factor in this example. Because the moment I reached the furthest node, I have reached every node in between.

I will use a BFS Approach. 

At starting node k, I will need some data structure to store this node-to-distance mapping so I can query for the furthest later, and I can use a HashMap for that. I can also use this Hash Table as a means to say "Here are the nodes that I have visited".

Next, I will need some data structure to know which node to process next. Since I am performing BFS, my first intuition is to use FIFO data structure so I can perform the nodes in-order. However, my goal is to find the shortest path to each node and put them in the visited list, and I realized there could be multiple neighbors and different distances to each neighbor, so I would need to process the shortest one first.

So in-order to process the shortest one first instead of FIFO, I will need a priority queue to do the job. 

One critical observation is that when I am processing a graph with loops using an adjacency list, I will encounter nodes multiple times from multiple source nodes. And my approach to this is only "record" (into the visited table) the first time I encounter them, and skip them if I already processed them. (This is why I need a HashMap, quick query time)

Each node will have three states, unvisited, visited, and processed.
I will go through the adjacency list, store neighbor nodes into heap, and process them by saying "if this is not visited, visit it and put all its neighbors into the heap (process it), else skip it".


High Level Idea: <br>
0. Construct Adjacency List from times table <br>
1. Initialize Heap: To store nodes and sort by cost to get to them from k <br>
2. Initialize table: To store visited nodes and their costs <br>
3. While heap is not empty: <br>
    a. Poll the current node <br>
    b. Process it <br>
        i. If not visited then put it into table and pull all neighbors into heap <br>
        ii else then skip this node and poll the next node from heap <br>
4. If unable to visit n nodes (table doesn't have n entries then return -1) <br> else Scan table and find the biggest cost node and return that time <br>

Create Adjacency List 
1. For each edge (src, dst, cost):
    a. map[src] = {dst, cost}

High Level Idea:
1. Initialize Heap with all starting points marked with cost = 0, a HashMap to represent visited nodes and their costs
2. While heap is not empty:
    a. Poll out one node
    b. If it has already been expanded, skip it
    c. otherwise mark the node as visited, update its cost
    d. For all its neighbors, offer them into the heap with current node's cost + edge cost (delay time)



    

 */
