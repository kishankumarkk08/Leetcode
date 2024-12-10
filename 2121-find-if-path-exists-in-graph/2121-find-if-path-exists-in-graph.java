class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map <Integer, List<Integer>> graph = new HashMap();
        for(int [] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, value->new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, value->new ArrayList<>()).add(u);
        }

        boolean vis[] = new boolean[n];
        for(int i = 0; i < vis.length; i++) vis[i] = false;
        vis[source] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(curr == destination) return true;
            for(int neighbor : graph.get(curr)) {
                if(!vis[neighbor]) {
                    q.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }

        return false;
    }
}