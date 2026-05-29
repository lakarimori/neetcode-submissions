class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }
        if (temperatures.length == 1) {
            return new int[]{0};
        }

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<temperatures.length;i++) {
            int currentTemp = temperatures[i];
            int days = 1;
            int next = i+1;

            while (next < temperatures.length && currentTemp >= temperatures[next]) {
                days++;
                next++;

            }

            if (next >= temperatures.length) {
                days = 0;
            }

            result.add(days);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
