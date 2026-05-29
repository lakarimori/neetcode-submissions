class Solution {
    public int[] replaceElements(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                int current = arr[i];
                arr[i] = -1;
                for (int j=i-1; j>=0 && arr[j]<current; j--) {
                    arr[j] = current;
                }
            }
        }

        if (arr[arr.length-1] != -1) {
            for (int i=0; i<arr.length-1; i++) {
                arr[i] = arr[i+1];
            }

            arr[arr.length-1] = -1;
        }

        return arr;
    }
}