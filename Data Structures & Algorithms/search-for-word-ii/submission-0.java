class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            boolean wordFound = false;
            for (int i=0; i<board.length; i++) {
                for (int j=0; j<board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        wordFound = findWord(board, word, visited, i, j, 0);
                        if (wordFound) {
                            result.add(word);
                            break;
                        }
                    }
                }
                if (wordFound) {
                    break;
                }
            }
        }

        return result;
    }

    private boolean findWord(char[][] board, String word, boolean[][] visited, int row, int col, int i) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(i)) {
            return false;
        }

        visited[row][col] = true;
        boolean found = findWord(board, word, visited, row, col-1, i+1) ||
                        findWord(board, word, visited, row, col+1, i+1) ||
                        findWord(board, word, visited, row-1, col, i+1) ||
                        findWord(board, word, visited, row+1, col, i+1);
        
        visited[row][col] = false;
        return found;
    }
}