class Solution {
    public int maxArea(int[] height) {
        int height1 = 0;
        int width = 0;
        int waterLevel = Integer.MIN_VALUE;
        int lp = 0;
        int rp = height.length - 1;
        while(lp < rp) {
            height1 = Math.min(height[lp],height[rp]);
            width = rp - lp;
            int water = height1 * width;
            waterLevel = Math.max(waterLevel, water);
            if(height[lp] < height[rp]) {
                lp++;
            }
            else {
                rp--;
            }
        }
        return waterLevel;
    }
}