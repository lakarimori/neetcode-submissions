class Solution {
    boolean[][] visited;

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        Set<int[]> sinkList;

        for (int i=1; i<n-1; i++) {
            for (int j=1; j<m-1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    sinkList = new HashSet<>();
                    if (shoulSinkRegion(board, i, j, sinkList)) {
                        for (int[] toSink : sinkList) {
                            board[toSink[0]][toSink[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean shoulSinkRegion(char[][] board, int row, int col, Set<int[]> sinkList) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return true;
        }
        if (board[row][col] == 'X') {
            return true;
        }
        if (row == 0 || col == 0 || row == board.length-1 || col == board[0].length-1) {
            return false;
        }
        if (visited[row][col]) {
            return true;
        }

        visited[row][col] = true;
        sinkList.add(new int[]{row, col});

        boolean res1 = shoulSinkRegion(board, row+1, col, sinkList);
        boolean res2 = shoulSinkRegion(board, row-1, col, sinkList);
        boolean res3 = shoulSinkRegion(board, row, col+1, sinkList);
        boolean res4 = shoulSinkRegion(board, row, col-1, sinkList);
        
        return res1 && res2 && res3 && res4;
    }
}