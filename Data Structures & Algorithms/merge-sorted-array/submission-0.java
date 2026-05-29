class Solution {
    /*
    pointer1 -> nums1
    pointer2 - > nums2
    while 1 && 1 ! null

    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0; i<n; i++) {
            nums1[m+i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}