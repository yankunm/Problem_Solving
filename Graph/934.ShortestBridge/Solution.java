class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int firstX = -1, firstY = -1;
        
        // Find any land cell, and we treat it as a cell of island A.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }

        // bfsQueue for BFS on land cells of island A; secondBfsQueue for BFS on water cells.
        List<int[]> bfsQueue = new ArrayList<>();
        List<int[]> secondBfsQueue = new ArrayList<>();
        bfsQueue.add(new int[]{firstX, firstY});
        secondBfsQueue.add(new int[]{firstX, firstY});
        grid[firstX][firstY] = 2;

        // BFS for all land cells of island A and add them to secondBfsQueue.
        while (!bfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (int[] cell : bfsQueue) {
                int x = cell[0];
                int y = cell[1];
                for (int[] next : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = next[0];
                    int curY = next[1];
                    if (curX >= 0 && curX < n && curY >= 0 && curY < n && grid[curX][curY] == 1) {
                        newBfs.add(new int[]{curX, curY});
                        secondBfsQueue.add(new int[]{curX, curY});
                        grid[curX][curY] = 2;
                    }
                }
            }
            bfsQueue = newBfs;
        }

        int distance = 0;
        while (!secondBfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (int[] cell : secondBfsQueue) {
                int x = cell[0];
                int y = cell[1];
                for (int[] next : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = next[0];
                    int curY = next[1];
                    if (curX >= 0 && curX < n && curY >= 0 && curY < n) {
                        if (grid[curX][curY] == 1) {
                            return distance;
                        } else if (grid[curX][curY] == 0) {
                            newBfs.add(new int[]{curX, curY});
                            grid[curX][curY] = -1;
                        }
                    }
                }
            }

            // Once we finish one round without finding land cells of island B, we will
            // start the next round on all water cells that are 1 cell further away from
            // island A and increment the distance by 1.
            secondBfsQueue = newBfs;
            distance++;
        }
        return distance;
}
}

/**
private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] grid) {

        // Initialize queue with all entry points
        int n = grid.length;
        Deque<int[]> frontier = new ArrayDeque<>();

        // Initialize visited record
        boolean[][] visited = new boolean[n][n];

        // for each node in grid
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    // check in all four directions
                    for(int[] d: DIRECTIONS){
                        int x = i + d[0], y = j + d[1];

                        // if adjacent node is valid and 0
                        if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0){

                            // add (i, j) as an entry point
                            frontier.add(new int[]{i, j});
                            visited[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        // Maintain levels counter
        int levels = 0;

        // Loop through every level in graph
        while(!frontier.isEmpty()){
            
            // Extract level size
            int size = frontier.size();

            // for each node in current level
            for(int k=0; k<size; k++){
                // Poll element
                int[] curr = frontier.poll();
                int i = curr[0], j = curr[1];


                // Expand element
                for(int[] d: DIRECTIONS){
                    int x=i + d[0], y=j + d[1];
                    // if valid
                    if(x >= 0 && x < n && y >= 0 && y < n){
                        // if unvisited and 0: mark and offer
                        if(grid[x][y] == 0 && !visited[x][y]){
                            frontier.offer(new int[]{x, y});
                            grid[x][y] = 1;
                            visited[x][y] = true;
                        } else if(grid[x][y] == 0){
                            return levels;
                        }
                    }                    
                }
            }
            // Increment levels after expanding nodes
            levels++;
        }

        // Finalize
        return levels-1;
    }

Intuition 1: BFS

High Level Idea:

Entry Points: int[]{i, j} of all 1 that is next to some 0 in grid

1. Initialize queue with all entry points (all 1s next to some 0), visited[][] for record
level = 0
2. Loop each level in graph:
    a. Record current level size
    b. Increment level count before expanding
    c. for each node in current level
        i. poll it
        ii. expand it
            -if unvisited and valid (within bounds) then offer
            -else if valid (encountered visited node) then return level
3. return -1



 */
