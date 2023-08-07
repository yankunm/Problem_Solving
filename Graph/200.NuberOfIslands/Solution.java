class Solution {

    public static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,1},{0,-1}}; 

    public int numIslands(char[][] grid) {
        // Initialize
        int countIslands = 0;

        // Loop through each element in grid
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                // if unvisited 1 then call dfs
                if(grid[i][j] == '1'){
                    countIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        // Finalize
        return countIslands;
    }

    
    private void dfs(char[][] grid, int i, int j){
        // Mark grid[i][j] as visited
        grid[i][j] = '0';

        // Loop through each neighbor of (i, j)
        for(int[] d: DIRECTIONS){
            // Get neighbor coordinates
            int x=i+d[0], y=j+d[1];

            // If not valid then skip (out of bounds, visited)
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0'){
                // Skip it
                continue;
            }

            // If visit, block and go deeper
            dfs(grid, x, y);
        }
    }
}

/**

High Level Idea:
1. Call dfs on every unvisited 1 in matrix (O(m*n))
2. Everytime a unvisited 1 is encountered, increment count of islands

dfs:
1. Set matrix[i][j] = 0 (mark it as visited)
2. For each neighbor:
    a. If neighbor is not valid, skip
    b. dfs (on that neighbor)

Note: dfs blocks on a valid neighbor before going to any other neighbor

Note: dfs here is top-down recursion, the current state is passed as parameter to the subproblem

Time: O(m*n) (Every element is at most visited twice)
Space: O(1) (In-place algorithm)





check left right up down
Unable to traverse anymore:
when a 1 is surrounded by all visited 1s or 0s

unvisited 1s and 0s
visit each 1 -- make them a 0

Idea 1: (too mushy, poor modeling of problem)

Maintain a counter.
Find and Start at a 1, increment counter, and repeatedly make adjacent 1s 0s until surrounded by 0s. repeat until theres no "1" in the entire array.

Insight: "repeatedly make adjacenet 1s 0s until surrounded by 0s"" --> dfs

Find a 1 in the array -- O(m x n)
Use that 1 and make adjacent 1s 0s -- O(m x n)
Find a new 1 in the array -- O(m x n)

______________________________________________________________

Idea 2: (depth first search and recursion)

DFS on a root 1 and each neighboring 1s.
Everytime encounter a 1, increment counter and start dfs on the "node" until can't anymore.

depth first search:
pop back when: 
-encouters 0
-encounter the boundary (OutOfBounds) (make sure no array access)
repeatedly go left, right, top, bottom, pop back here using call stack.

 */


