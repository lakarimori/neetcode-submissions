class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int rowSize = boxGrid.length;
        int columnSize = boxGrid[0].length;
        char[][] rotated = new char[columnSize][rowSize];

        for (int i=rowSize-1; i>=0; i--) {
            for (int j=columnSize-1; j>=0; j--) {
                if (boxGrid[i][j] == '#') {
                    int aux = j + 1;
                    while (aux < columnSize && boxGrid[i][aux] == '.') {
                        aux++;
                    }

                    boxGrid[i][j] = '.';
                    boxGrid[i][aux-1] = '#';
                }
            }
        }

        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<columnSize; j++) {
                rotated[j][rowSize - 1 - i] = boxGrid[i][j];
            }
        }

        return rotated;
    }
}