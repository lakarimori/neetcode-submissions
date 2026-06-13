class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int total = 0;
        int left = 0;
        int count = 0;

        for (int r=0; r<arr.length; r++) {
            count += arr[r];

            if (r - left + 1 == k) {
                int average = count / k;
                if (average >= threshold) {
                    total++;
                }

                count -= arr[left];
                left++;
            }
        }

        return total;
    }
}