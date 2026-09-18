class Solution {
    List<List<Integer>> adjList;
    int[] state;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Detect if got cycles, use DFS with three states
        // State 0 = unvisited, 1 = exploring, 2 = visited
        state = new int[numCourses];
        adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int u = p[0], v = p[1];
            adjList.get(u).add(v);
        }

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && containsCycle(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean containsCycle(int course) {
        state[course] = 1;
        List<Integer> neighbours = adjList.get(course);

        for (int i = 0; i < neighbours.size(); i++) {
            int n = neighbours.get(i);
            if (state[n] == 1) {
                return true;
            }

            if (state[n] == 0 && containsCycle(n)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}
