class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean isUnlocked[] = new boolean[rooms.size()];
        isUnlocked[0] = true;
        Queue <Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int curr = q.remove();
            for(int keys: rooms.get(curr)) {
                if(!isUnlocked[keys]) {
                    isUnlocked[keys] = true;
                    q.add(keys);
                }
            }
        }
        for(int i = 0; i < isUnlocked.length; i++) {
            if(!isUnlocked[i]) {
                return false;
            }
        }
        return true;
    }
}