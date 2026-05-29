class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    sinkIsland(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void sinkIsland(char[][] grid, int row, int column) {
        if (row >= grid.length || row < 0 || column < 0 || column >= grid[0].length || grid[row][column] != '1') {
            return;
        }

        grid[row][column] = '0'; //sinked

        sinkIsland(grid, row - 1, column);
        sinkIsland(grid, row + 1, column);
        sinkIsland(grid, row, column - 1);
        sinkIsland(grid, row, column + 1);
    }
}
