class Solution {
    /*
    [
    [1,2,3,4],
    [5,0,7,8],
    [0,10,11,12],
    [13,14,15,0]]

    [
    [0,0,3,0],
    [0,0,0,0],
    [0,0,0,0],
    [0,0,0,0]]

    [
    [1,0,3,4],
    [0,0,0,0],
    [0,0,11,0],
    [0,0,0,0]]
    */
    public void setZeroes(int[][] matrix) {
        Set<List<Integer>> originalZeroes = new HashSet<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    originalZeroes.add(List.of(i, j));
                }
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (originalZeroes.contains(List.of(i, j))) {
                    int up = i - 1;
                    while (up >= 0) {
                        matrix[up][j] = 0;
                        up--;
                    }
                    int down = i + 1;
                    while (down < matrix.length) {
                        matrix[down][j] = 0;
                        down++;
                    }
                    int right = j + 1;
                    while (right < matrix[0].length) {
                        matrix[i][right] = 0;
                        right++;
                    }
                    int left = j - 1;
                    while (left >= 0) {
                        matrix[i][left] = 0;
                        left--;
                    }
                }
            }
        }
    }
}