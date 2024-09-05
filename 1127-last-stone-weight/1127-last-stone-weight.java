class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while(pq.size() > 1) {
            int s1 = pq.remove();
            int s2 = pq.remove();
            int s = s1 - s2;
            pq.add(s);
        }
        return pq.remove();
    }
}