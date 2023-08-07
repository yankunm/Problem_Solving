# Graph

Tree: Acyclic Simple Undirected Graph with only One Entry Point

## Graph Representation

* Adjacency Matrix
* Adjacency List (More common)

## Adjacency List

* **List\<T\>[n]**: Need to know number of nodes (n) beforehand <br>
--adjList[i] --> neighbors of node i
* **Map<T, List\<T\>>**: More versatile <br>
--adjList.get(i) --> neighbors of node i

## Adjacency Matrix

Tip: For 2D Matrix Graphs, neighbors of matrix[i][j] is usually top, bottom, left, and right. So it is useful to store 4 direction array to visit neighbors.

i.e. \[ \[0,1\], \[1,0\], \[0,-1\], \[-1,0\] \]

## Graph BFS

A Graph might have CYCLES so we need to check for DUPLICATES. Drop breadcrumb.

*Note: Shortest path in an UNWEIGHTED graph can be found using BFS.*

### BFS Template

BFS High Level Idea: <br>
1. Initialize Queue with all entry points <br>
2. Initialize HashSet to record discovered nodes <br>
3. Loop through each level of the graph: <br>
   a. Record current level stats <br>
   b. Loop through each node in this level <br>
        i. Poll node <br>
        ii. Process node <br> 
        iii. Expand node only if *not visited* and *valid* <br>
   c. Increase level <br>
   
## Graph Best-First Search

Expand the BEST nodes first, used on Non-uniform cost graphs.

How to quickly calculate the BEST: **Heaps**

Most famous algorithm to find the shortest path in a weighted graph: **Dijsktra's Algorithm**

Time: O((V + E) log V) <br>
Space: O(V) <br>

Best-First Search Dijsktra High Level Idea: <br>
1. Initialize **Heap** with all starting points marked with some initial cost, a **HashSet** to record visited values. <br>
2. While Heap is not empty: <br>
   a. Poll out one node <br>
   b. If it has already been expanded, skip it <br>
   c. Otherwise mark the node as visited, update its cost <br>
   d. If this is the detination node, return <br>
   e. For all of its neighbors, offer them into the heap with current node's cost + edge cost

## Graph DFS

Go deep to the end of one route, recurse back to the starting point, and go deep to the end of another route.

### DFS High Level Idea

1. Initialize HashSet to record visited nodes <br>
2. For all entry nodes, call dfs(): <br>
   a. *Validate current node* (if not valid or visited then return) <br>
   b. **Do Something (Pre-order)** <br>
   c. For each neighbor node: <br>
      1. *Validate neighbor node* (if not valid or visited then return) <br>
      2. Recurse down on neighbor node <br>
d. **Do Something (Post-order)** <br>









