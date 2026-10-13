/*
 * Time:  O(V * (V + E) + Q)
 *   - One DFS per course to fill reach[src]: V DFS runs, each O(V + E), since each   
 *       node has their own "visited array" in 2D reach matrix
 *   - Each query is then an O(1) lookup: O(Q)
 *
 * Space: O(V^2 + V + E)
 *   - reach matrix: O(V^2)
 *   - adjacency list: O(V + E)
 *   - recursion stack of DFS: O(V), but dominated by reach matrix
 *
 * Why it's better than DFS-per-query (O(Q * (V + E))):
 *   - The old approach reran a DFS for every query, so the same course
 *     could be searched thousands of times (Q up to 10^4).
 *   - Here each course is searched exactly once (V <= 100) and the
 *     results are cached in reach, so repeated queries cost nothing extra.
 *   - Same idea as memoisation: identical search, just never repeated.
 */

class Solution {
    List<List<Integer>> adjList;
    boolean[][] reach;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adjList = new ArrayList<>();
        // reach[src] doubles as the visited array for the DFS from src and 
        // afterwards reach[u][v] answers "can u reach v?" in O(1)
        reach = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int u = prereq[0], v = prereq[1];
            adjList.get(u).add(v);
        }

        for (int i = 0; i < numCourses; i++) {
            dfs(i, i);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            ans.add(reach[q[0]][q[1]]);
        }

        return ans;
    }

    // DFS also has to record where it started, so it knows which row of reach to write into -> Hence two parameters
    public void dfs(int src, int u) {
        List<Integer> neighbours = adjList.get(u);
        for (int i = 0; i < neighbours.size(); i++) {
            int next = neighbours.get(i);
            if (!reach[src][next]) {
                reach[src][next] = true;
                dfs(src, next);
            }
        }
    }
}