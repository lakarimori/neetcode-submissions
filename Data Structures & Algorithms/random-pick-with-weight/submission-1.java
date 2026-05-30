class Solution {
    int[] weights;
    int sum;
    
    public Solution(int[] w) {
        weights = w;
        sum = 0;
        for (int weight : w) {
            sum += weight;
        }
    }

    public int pickIndex() {
        double random = Math.random();
        double target = sum * random;
        int currSum = 0;
        for (int i=0; i<weights.length; i++) {
            currSum += weights[i];
            if (currSum > target) {
                return i;
            }
        }

        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */