class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;

        while (left < right && top < bottom) {
            for (int i=left; i<right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i=top; i<bottom; i++) {
                result.add(matrix[i][right-1]);
            }
            right--;

            if (left >= right || top >= bottom) {
                break;
            }

            for (int i=right-1; i>=left; i--) {
                result.add(matrix[bottom-1][i]);
            }
            bottom--;

            for (int i=bottom-1; i>=top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }

    /*
        [
        [1 ,2 ,3 ,4],
        [5 ,6 ,7 ,8],
        [9 ,10,11,12],
        [13,14,15,16]]

        [1,2,3,4,8,12,16,15,14,13,9,10,11,7,6,5]
    */
}
