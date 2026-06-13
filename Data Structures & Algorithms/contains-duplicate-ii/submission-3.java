class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k==0) {
            return false;
        }

        List<Integer> set = new ArrayList<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }

            if (set.size() >= k) {
                set.remove(0);
            }

            set.add(num);
        }

        return false;
    }
}