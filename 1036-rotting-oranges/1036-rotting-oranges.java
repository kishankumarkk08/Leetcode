class Solution {
    class Pair{
        int f;
        int s;
        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    public boolean bounds(int ni, int nj, int n, int m) {
        return (ni >= 0 && ni < m && nj >= 0 && nj < n);
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        Queue <Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) return 0;
        int time = 0;
        int neighbors[][] = {{0,-1}, {0, 1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false; 
            
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                
                for (int[] neighbor : neighbors) {
                    int ni = curr.f + neighbor[0];
                    int nj = curr.s + neighbor[1];
                    
                    if (bounds(ni, nj, n, m) && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2; 
                        q.add(new Pair(ni, nj)); 
                        freshCount--; 
                        rotted = true;
                    }
                }
            }
            
            
            if (rotted) time++;
        }
        
        
        return freshCount == 0 ? time : -1;
    }
}