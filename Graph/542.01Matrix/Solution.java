class Solution {

    // Four directions used for checking adjacent values in 2D Matrix
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        // Initialize
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n]; // default 0

        // Initialize Queue
        Deque<int[]> frontier = new ArrayDeque<>();

        // Initialize visit record
        boolean[][] visited = new boolean[m][n];

        // Put all entry points into queue O(mn)
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    frontier.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // Initialize level counter
        int level = 0;

        // Loop through each level
        while(!frontier.isEmpty()){
            // Extract size of current level
            int size = frontier.size();

            // Loop through current level
            for(int k=0; k<size; k++){
                // Poll out coordinate
                int[] curr = frontier.poll();
                int i=curr[0], j=curr[1];

                // Process coordinate (Update result)
                if(mat[i][j] == 1){
                    res[i][j] = level;
                }

                // Expand coordinate
                for(int[] d: DIRECTIONS){
                    // Get the wanted x and y coodinates
                    int x = i + d[0], y = j + d[1];

                    // If not visited and valid
                    if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]){
                        frontier.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            // Increment level
            level++;
        }

        // Finalize
        return res;
    }
}

/**

Find: cost from this 0 to 1

BFS --> O(nm)

Intuition: for each 1, use BFS to find the nearest 0 --> O(nm * nm)

Reversed Intuition: for all 0, use BFS to find and fill in 1 level-by-level --> O(nm)

BFS High Level Idea: <br>
1. Initialize Queue with ALL 0 NODES, a boolean[][] to record visited nodes <br>
2. While Queue is not empty: <br>
    a. Get current level stats <br>
    b. For each node in current level <br>
        i. Poll out one node
        ii. Process node
        iii. Expand node if not visited and valid
    c. Increase Level

Time: O(mn)
Space: O(mn)

 */
