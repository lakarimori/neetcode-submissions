class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxWeight = new PriorityQueue<>(Comparator.reverseOrder()); 

        for (int stone : stones) {
            maxWeight.add(stone);
        }

        while (!maxWeight.isEmpty()) {
            int stoneX = maxWeight.poll();
            if (maxWeight.isEmpty()) {
                return stoneX;
            }
            int stoneY = maxWeight.poll();

            if (stoneX > stoneY) {
                stoneX -= stoneY;
                maxWeight.add(stoneX);
            }
        }

        return 0;
    }
}
