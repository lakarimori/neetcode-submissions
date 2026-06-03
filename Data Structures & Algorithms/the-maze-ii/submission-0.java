class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]] = 0;
        
        dfs(maze, start, distance);

        int shortestDest = distance[destination[0]][destination[1]];

        return shortestDest == Integer.MAX_VALUE ? -1 : shortestDest;
    }

    private void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for (int[] dir : dirs) {
            int row = start[0] + dir[0];
            int col = start[1] + dir[1];
            int count = 0;

            while (row >= 0 && col >= 0 && row < maze.length 
            && col < maze[0].length && maze[row][col] == 0) {
                row += dir[0];
                col += dir[1];
                count++;
            }

            if (distance[start[0]][start[1]] + count < distance[row - dir[0]][col - dir[1]]) {
                distance[row - dir[0]][col - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{row - dir[0],col - dir[1]}, distance);
            }
        } 
    }
}
