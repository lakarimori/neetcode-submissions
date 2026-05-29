class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> numSeen = new ArrayList<>();
        
        for (int num : nums) {
            if (numSeen.contains(num)) {
                return true;
            }

            numSeen.add(num);
        }

        return false;
    }
}