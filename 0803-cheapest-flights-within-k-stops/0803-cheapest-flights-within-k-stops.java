class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> list[] = new ArrayList[n];
        createGraph(flights, list);
        int dist[] = new int[n];
        for(int i = 0; i < dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                break;
            }
            for(Edge neighbors : list[curr.vertex]) {
                int u = neighbors.src;
                int v = neighbors.dest;
                int wt = neighbors.wt;
                if(curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[dst];
    }
    public void createGraph(int [][] flights, ArrayList<Edge> list[]) {
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            Edge e = new Edge(src, dest, wt);
            list[src].add(e);
        }
    }
    class Info {
        int vertex;
        int cost;
        int stops;
        public Info(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }
    class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
}