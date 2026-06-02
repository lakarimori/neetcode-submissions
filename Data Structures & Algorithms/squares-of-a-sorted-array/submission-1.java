class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=0, r = nums.length-1;
        List<Integer> result = new ArrayList<>();

        while (l <= r) {
            int squareL = nums[l] * nums[l];
            int squareR = nums[r] * nums[r];

            if (squareL < squareR) {
                result.add(squareR);
                r--;
            } else {
                result.add(squareL);
                l++;
            }
        } 
        
        Collections.reverse(result);

        return result.stream().mapToInt(i -> i).toArray();
    }
}