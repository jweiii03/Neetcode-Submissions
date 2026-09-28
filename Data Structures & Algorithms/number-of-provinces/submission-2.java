class Solution {
    ArrayList<ArrayList<Integer>> adjList;
    boolean[] visited;

    public void dfs(int city) {
        visited[city] = true;

        for (int i = 0; i < adjList.get(city).size(); i++) {
            int neighbour = adjList.get(city).get(i);
            if (!visited[neighbour]) {
                dfs(neighbour);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int totalCities = isConnected.length;
        int totalProvinces = 0;

        adjList = new ArrayList<>();
        for (int i = 0; i < totalCities; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < totalCities; i++) {
            for (int j = 0; j < totalCities; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }   
        }

        visited = new boolean[totalCities];

        for (int i = 0; i < totalCities; i++) {
            if (!visited[i]) {
                totalProvinces++;
                dfs(i);
            }
        }

        return totalProvinces;
    }
}