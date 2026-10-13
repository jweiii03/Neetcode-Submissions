/*
Time complexity: DFS -> O(V + E)
Space complexity: Adjacency list occupies O(V + E) space, The state array, the stack, 
    and the recursion call stack (up to V frames deep for a long chain) each take 
    O(V), which is dominated by adjList space
*/

class Solution {
    List<List<Integer>> adjList;
    int[] state;
    // We use stack as DFS finishes nodes in post-order, and topological order is the reverse of the stack order
    Stack<Integer> ans;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Initialise adjList
        adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adjList.get(p[1]).add(p[0]);
        }

        // 0 = unvisited, 1 = exploring, 2 = visited
        state = new int[numCourses]; 
        ans = new Stack<>();

        // Perform DFS on every course
        for (int i = 0; i < numCourses; i++) {
            // If detected a cycle, impossible to finish all courses, return empty list
            if (state[i] == 0 && dfs(i)) {
                return new int[0];
            }
        }

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = ans.pop();
        }
        return order;
    }

    public boolean dfs(int course) {
        state[course] = 1;
        List<Integer> neighbours = adjList.get(course);
        for (int i = 0; i < neighbours.size(); i++) {
            int n = neighbours.get(i);
            // If DFS explored a neighbour that state = 1 (exploring), cycle detected
            if (state[n] == 1) {
                return true;
            }

            if (state[n] == 0 && dfs(n)) {
                return true;
            }
        }

        // Push to stack once visit all neighbours of a node (Post order)
        ans.push(course);
        state[course] = 2;
        return false;
    }
}
