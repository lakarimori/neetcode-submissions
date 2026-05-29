class LRUCache {

    Map<Integer, Integer> values;
    Queue<Integer> queue;
    int limit;

    public LRUCache(int capacity) {
        values = new HashMap<>();
        queue = new LinkedList<>();
        limit = capacity;
    }
    
    public int get(int key) {
        int res = values.getOrDefault(key, -1);

        if (res != -1) {
            queue.remove(key);
            queue.offer(key);
        }
        return res;
    }
    
    public void put(int key, int value) {
        if (values.containsKey(key)) {
            values.put(key, value);
            queue.remove(key);
            queue.offer(key);
            return;
        }

        if (values.size() >= limit) {
            int keyToRemove = queue.poll();
            values.remove(keyToRemove);
        }

        values.put(key, value);
        queue.offer(key);
    }
}
