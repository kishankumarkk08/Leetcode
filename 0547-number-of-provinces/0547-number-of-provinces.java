class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean vis[] = new boolean[isConnected.length];
        Arrays.fill(vis, false);
        for(int i = 0; i < isConnected.length; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1) {
                    graph.get(i).add(i);
                    graph.get(j).add(i);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(!vis[i]) {
                count++;
                bfs(i, isConnected, vis, graph);
            }
        }
        return count;
    }
    public void bfs(int start, int[][] isConnected, boolean[] vis, ArrayList<ArrayList<Integer>> graph) {
        Queue <Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int curr = q.remove();
            for(int neighbors: graph.get(curr)) {
                if(!vis[neighbors]) {
                    vis[neighbors] = true;
                    q.add(neighbors);
                }
            }
        }
    }
}