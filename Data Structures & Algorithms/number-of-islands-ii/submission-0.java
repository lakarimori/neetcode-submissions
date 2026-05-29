class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        List<Integer> result = new ArrayList<>();
        for (int[] position : positions) {
            grid[position[0]][position[1]] = 1;
            int[][] copy = Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (copy[i][j] == 1) {
                        count++;
                        sink(copy, i, j);
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private void sink(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) {
            return;
        }
        grid[row][column] = 0;
        sink(grid, row + 1, column);
        sink(grid, row - 1, column);
        sink(grid, row, column + 1);
        sink(grid, row, column - 1);
    }
}