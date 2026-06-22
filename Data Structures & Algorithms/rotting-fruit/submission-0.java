class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int fresh = 0;
        int[][] directions = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pos = queue.poll();

                for (int[] dir : directions) {
                    int nr = pos[0] + dir[0];
                    int nc = pos[1] + dir[1];

                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && 
                        grid[nr][nc] == 1) {
                            fresh--;
                            queue.offer(new int[]{nr, nc});
                            grid[nr][nc] = 2;
                    }
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
