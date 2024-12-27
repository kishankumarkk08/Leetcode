class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < isConnected.length; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean vis[] = new boolean[isConnected.length];
        Arrays.fill(vis, false);
        int count = 0;
        for(int i = 0; i < graph.size(); i++) {
            if(!vis[i]) {
                count++;
                bfs(i,isConnected, graph, vis);
            }
        }
        return count;

    }
    public void bfs(int start,int[][] isConnected, ArrayList<ArrayList<Integer>> graph , boolean[] vis) {
        Queue <Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int curr = q.remove();
            for(int neighbors : graph.get(curr)) {
                if(!vis[neighbors]) {
                    vis[neighbors] = true;
                    q.add(neighbors);
                }
            }
        }
    }

}