# 542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

_____________________________________________-

Find: cost from this 0 to 1

BFS --> O(nm)

Intuition: for each 1, use BFS to find the nearest 0 --> O(nm * nm)

Reversed Intuition: for all 0, use BFS to find and fill in 1 level-by-level --> O(nm)

BFS High Level Idea: <br>
1. Initialize Queue with ALL 0 NODES, a boolean[][] to record visited nodes <br>
2. While Queue is not empty: <br>
    a. Get current level stats <br>
    b. For each node in current level <br>
        i. Poll out one node <br>
        ii. Process node <br>
        iii. Expand node if not visited and valid <br>
    c. Increase Level <br>

Time: O(mn) <br>
Space: O(mn)
