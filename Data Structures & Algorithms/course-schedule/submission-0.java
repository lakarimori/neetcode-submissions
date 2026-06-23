class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] prereq : prerequisites) {
            List<Integer> list = adj.getOrDefault(prereq[1], new ArrayList<>());
            list.add(prereq[0]);
            adj.put(prereq[1], list);
        }

        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canDoCourse(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean canDoCourse(int course) {
        if (visited[course] == 1) return false;
        if (visited[course] == 2) return true;

        visited[course] = 1;
        if (adj.get(course) != null) {
            for (int nextCourse : adj.get(course)) {
                if (!canDoCourse(nextCourse)) return false;
            }
        }
        
        visited[course] = 2;
        return true;
    }
}