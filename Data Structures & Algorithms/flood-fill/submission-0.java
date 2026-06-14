class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];

        fill(image, sr, sc, color, target);

        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int target) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != target || image[sr][sc] == color) {
            return;
        }

        image[sr][sc] = color;

        fill(image, sr-1, sc, color, target);
        fill(image, sr+1, sc, color, target);
        fill(image, sr, sc-1, color, target);
        fill(image, sr, sc+1, color, target);
    }
}