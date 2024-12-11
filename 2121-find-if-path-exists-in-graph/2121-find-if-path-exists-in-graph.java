class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, value -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, value -> new ArrayList<>()).add(u);
        }
        boolean vis[] = new boolean[n];
        for (int i = 0; i < vis.length; i++) {
            vis[i] = false;
            
        }
        vis[source] = true;

        return dfs(graph, source, destination, vis);


    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination, boolean vis[]) {
        if(source == destination) {
            return true;
        }
        for(int neighbor : graph.get(source)) {
            if(!vis[neighbor]) {
                vis[neighbor] = true;
                if(dfs(graph, neighbor, destination, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    

}