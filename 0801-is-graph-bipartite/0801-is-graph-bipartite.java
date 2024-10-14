class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for(int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i++) {
            if(color[i] == -1) {
                q.add(i);
                color[i] = 0;
            }
            while(!q.isEmpty()) {
                int curr = q.remove();
                for(int neighbor : graph[curr]) {
                    if(color[neighbor] == -1) { 
                        int nextColor = color[curr] == 0 ? 1 : 0;
                        color[neighbor] = nextColor;
                        q.add(neighbor);  
                    } 
                    else if(color[neighbor] == color[curr]) {  
                        return false;
                    }
                }
            }
        }
        return true;
    }
}