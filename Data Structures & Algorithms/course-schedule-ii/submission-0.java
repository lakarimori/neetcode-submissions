class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[]{};
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] visited = new int[numCourses]; // 0: unvisited, 1: visiting, 2: visited
        List<Integer> result = new ArrayList<>();

        for (int[] pre : prerequisites) {
            adj.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, adj, result, visited)) {
                    return new int[]{};
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> adj, List<Integer> result, int[] visited) {
        if (visited[course] == 1) {
            return false;
        }
        if (visited[course] == 2) {
            return true;
        }

        visited[course] = 1;

        for (int pre : adj.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(pre, adj, result, visited)) {
                return false;
            }
        }

        visited[course] = 2;
        result.add(course);
        return true;
    }
}