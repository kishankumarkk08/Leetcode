class Solution {
    static class Points implements Comparable <Points> {
        int x;
        int y;
        int dist;
        Points (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;

        }
        @Override
        public int compareTo(Points p2) {
            return this.dist - p2.dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue <Points> pq = new PriorityQueue<>();
        for(int i = 0; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new Points(points[i][0], points[i][1],dist));
        }
        int[][] ans = new int [k][2];
        for(int i = 0; i < k; i++) {
            Points closestPoint = pq.remove();
            ans[i][0] = closestPoint.x;
            ans[i][1] = closestPoint.y;
        }
        return ans;
    }
}