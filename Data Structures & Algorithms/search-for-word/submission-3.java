/*
[["A","B","C","E"]
,["S","F","E","S"]
,["A","D","E","E"]]

*/
class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;

        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[row][column];
                    if (searchWord(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, int row, int column, int position) {
        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length 
        || board[row][column] != word.charAt(position) || visited[row][column]) {
            return false;
        }

        visited[row][column] = true;

        if (position == word.length() - 1) {
            return true;
        }

        boolean res = searchWord(board, word, row, column-1, position+1)
        || searchWord(board, word, row, column+1, position+1)
        || searchWord(board, word, row-1, column, position+1)
        || searchWord(board, word, row+1, column, position+1);

        visited[row][column] = false;

        return res;
    }
}
