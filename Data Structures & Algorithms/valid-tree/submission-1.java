/* 
- Undirected graph, a tree is a connected graph with no cycles
- Use DFS to detect cycles, by tracking 3 states (unvisited, exploring, visited) for each node
- Need a way to track previous node when detecting cycles. Trace n = 2, edges = [[0, 1]]. DFS goes 0 → 1, then node 1 sees node 0 still exploring and reports a cycle -> Wrong behaviour!

Time complexity: O(V + E), DFS checks every vertex and edge
Space complexity: O(V + E), Adjacency List stores V + 2E = V + E
*/
class Solution {
    List<List<Integer>> adjList;
    int[] state;

    public boolean validTree(int n, int[][] edges) {
        adjList = new ArrayList<>();
        state = new int[n];
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate adjList (Edges are undirected)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Since undirected, we can DFS any node, we DFS node 0 here
        if (detectCycles(0, -1)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            // If theres an unexplored vertex, means tree is not connected
            if (state[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean detectCycles(int node, int parent) {
        state[node] = 1; // Exploring
        // Traverse neighbours
        List<Integer> neighbours = adjList.get(node);
        for (int i = 0; i < neighbours.size(); i++) {
            int neighbour = neighbours.get(i);
            // Avoid visiting parent node as that is not counted as a cycle
            if (neighbour == parent) {
                continue;
            }

            if (state[neighbour] == 0 && detectCycles(neighbour, node)) {
                return true;
            }

            if (state[neighbour] == 1) {
                return true;
            }
        }

        state[node] = 2;
        return false;
    }
}
