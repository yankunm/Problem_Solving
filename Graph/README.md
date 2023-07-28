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
1. Initialize Queue with all entry points
2. Initialize HashSet to record discovered nodes
3. Loop through each level of the graph:
   a. Record current level stats
   b. Loop through each node in this level
     i. Poll node
     ii. Process node
     iii. Expand node only if *not visited* and *valid*
   c. Increase level







