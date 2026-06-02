class KthLargest {

    Queue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }
    }
    
    public int add(int val) {
        queue.add(val);

        List<Integer> temp = new ArrayList<>();
        for (int i=0; i<k-1; i++) {
            temp.add(queue.poll());
        }

        int result = queue.peek();

        for (int t : temp) {
            queue.add(t);
        }

        return result;
    }
}
