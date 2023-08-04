# 743. Network Delay Time

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

## Approach

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
        ii else then skip this node and poll the next noed from heap <br>
4. If unable to visit n nodes (table doesn't have n entries then return -1) <br> else Scan table and find the biggest cost node and return that time <br>
