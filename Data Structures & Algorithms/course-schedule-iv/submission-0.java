class Solution {
    List<List<Integer>> adjList;
    boolean[] visited;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int u = prereq[0], v = prereq[1];
            adjList.get(u).add(v);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            // Require a new visited array for each DFS query
            visited = new boolean[numCourses];
            ans.add(dfs(q[0], q[1]));
        }

        return ans;
    }

    public boolean dfs(int u, int v) {
        if (u == v) return true;
        visited[u] = true;
        for (int next : adjList.get(u)) {
            if (!visited[next] && dfs(next, v)) {
                return true;
            }
        }
        return false;
    }
}