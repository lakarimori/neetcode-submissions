class Solution {

    // is line valid?
    // is colunm valid?
    // is square 3x3 valid?

    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<board.length;i++) {
            if (!isLineValid(i, board)) {
                return false;
            }

            if (!isValidCoulnm(i, board)) {
                return false;
            }
        }    

        if (!isValidSquare(board)) {
            return false;
        }

        return true;
    }

    private boolean isLineValid(int i, char[][] board) {
        int[] count = new int[10];

        for (int j=0; j<board[i].length; j++) {
            if (board[i][j]=='.') {
                continue;
            }
            
            if (count[board[i][j]-'0'] > 0) {
                return false;
            } else {
                count[board[i][j]-'0']++;
            }
        }

        return true;
    }

    private boolean isValidCoulnm(int i, char[][] board) {
        int[] count = new int[10];

        for (int j=0; j<board[i].length; j++) {
            if (board[j][i]=='.') {
                continue;
            }

            if (count[board[j][i]-'0'] > 0) {
                return false;
            } else {
                count[board[j][i]-'0']++;
            }
        }

        return true;
    }

    private boolean isValidSquare(char[][] board) {
        for (int i=0; i<board.length; i+=3) {
            for (int j=0; j<=6; j+=3) {
                int[] count = new int[10];

                for (int x=0; x<3; x++) {
                    for (int y=0;y<3;y++) {
                        int currentRow = i + x;
                        int currentColunm = j + y;

                        if (board[currentRow][currentColunm]=='.') {
                            continue;
                        }

                        if (count[board[currentRow][currentColunm]-'0'] > 0) {
                            return false;
                        } else {
                            count[board[currentRow][currentColunm]-'0']++;
                        }
                    }
                }
                
            }
        }

        return true;
    }
}
