class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean list[] = new boolean[n];

        for(List<Integer> edge: edges) {
            int dest = edge.get(1);
            list[dest] = true;
        }
        for(int i = 0; i < list.length; i++) {
            if(!list[i]) {
                res.add(i);
            }
        }
        return res;
    }
}