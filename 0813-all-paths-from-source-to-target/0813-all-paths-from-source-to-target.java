class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> adj = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        adj.add(0);
        path(0, adj, graph, graph.length - 1, res);
        return res;
    }

    public void path(int src, List<Integer> adj, int graph[][], int dest, List<List<Integer>> res) {
        if (src == dest) {
            res.add(new ArrayList(adj));
            return;
        }
        for (int adjacents : graph[src]) {
            adj.add(adjacents);
            path(adjacents, adj, graph, dest, res);
            adj.remove(adj.size()-1);
        }
    }
}