class Solution {
    /*
    [
    [0,0,1,1,1],
    [0,0,1,1,1],
    [0,0,1,1,1],
    [1,1,1,1,1],
    [0,0,1,1,0]
    ]
    */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = start[0];
        int column = start[1];

        if (row < 0 || row >= maze.length || column < 0 || column >= maze[0].length || maze[row][column] == 2) {
            return false;
        }

        if (Arrays.equals(start, destination)) {
            return true;
        }

        maze[row][column] = 2;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : dirs) {
            int r = row, c = column;
            while (r + d[0] >= 0 
            && r + d[0] < maze.length 
            && c + d[1] >= 0 
            && c + d[1] < maze[0].length 
            && maze[r + d[0]][c + d[1]] != 1) {
                r += d[0];
                c += d[1];
            }
            if (hasPath(maze, new int[]{r, c}, destination)) return true;
        }

        return false;
    }
}