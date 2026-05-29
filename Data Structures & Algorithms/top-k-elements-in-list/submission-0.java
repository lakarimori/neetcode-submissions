class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequent = new HashMap<>();

        for (int num : nums) {
            frequent.put(num, frequent.getOrDefault(num, 0) + 1);
        }

        return frequent.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(k)
        .mapToInt(Map.Entry::getKey)
        .toArray();
    }
}
