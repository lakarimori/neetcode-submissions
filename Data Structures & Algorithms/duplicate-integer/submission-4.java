class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSeen = new HashSet<>();
        
        for (int num : nums) {
            if (numSeen.contains(num)) {
                return true;
            }

            numSeen.add(num);
        }

        return false;
    }
}