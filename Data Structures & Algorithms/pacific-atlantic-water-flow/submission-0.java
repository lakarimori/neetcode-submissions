class Solution {
    boolean pacific;
    boolean atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                pacific = false;
                atlantic = false;

                if (canFlow(heights, i, j, new boolean[n][m])) {
                    res.add(List.of(i,j));
                }
            }
        }

        return res;
    }

    private boolean canFlow(int[][] heights, int row, int col, boolean[][] visited) {
        if (visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        for (int[] dir : directions) {
            int curHeight = heights[row][col];
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr < 0 || nc < 0) {
                pacific = true;
            } else if (nr >= heights.length || nc >= heights[0].length) {
                atlantic = true;
            } else if (curHeight >= heights[nr][nc]) {
                canFlow(heights, nr, nc, visited);
            }
        }

        return pacific && atlantic;
    }
}
