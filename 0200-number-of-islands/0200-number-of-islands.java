class Solution {
    class Pair {
        int f;
        int s;
        public Pair (int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    public boolean bounds(int ni, int nj, int n, int m) {
        return (ni >= 0 && ni < m && nj >= 0 && nj < n);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                vis[i][j] = false;
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(grid, vis, m, n, i, j);
                }
            }

        }
        return count;
        
    }
    public void bfs(char[][] grid, boolean vis[][], int m, int n, int i, int j) {
        Queue<Pair> q = new LinkedList<>();
        int ni = i;
        int nj = j;
        q.add(new Pair(i,j));
        int neighbors[][] = {{0,-1}, {0, 1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            Pair curr = q.remove();
            for(int k = 0; k < 4; k++) {
                ni = curr.f + neighbors[k][0];
                nj = curr.s + neighbors[k][1];
                if(bounds(ni, nj, n, m) && !vis[ni][nj] && grid[ni][nj] == '1'){
                    vis[ni][nj] = true;
                    q.add(new Pair(ni, nj));
                }
            }
        }
    }
}