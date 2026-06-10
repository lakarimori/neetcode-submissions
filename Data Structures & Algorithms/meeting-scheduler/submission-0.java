class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a,b) -> Integer.compare(a[0], b[0]));

        int p1 = 0;
        int p2 = 0;

        while (p1 < slots1.length && p2 < slots2.length) {
            int start1 = slots1[p1][0];
            int end1 = slots1[p1][1];
            int start2 = slots2[p2][0];
            int end2 = slots2[p2][1];

            int intersectStart = Math.max(start1, start2);
            int intersectEnd = Math.min(end1, end2);

            if (intersectEnd - intersectStart >= duration) {
                return Arrays.asList(intersectStart, intersectStart + duration);
            }

            if (end1 < end2) {
                p1++;
            } else {
                p2++;
            }
        }

        return new ArrayList<>();
    }
}