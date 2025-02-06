class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        return climbStairsMemo(n,dp);
    }

    public int climbStairsMemo(int n, int dp[]) {
        if(n < 3) {
            return n;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climbStairsMemo(n-1,dp) + climbStairsMemo(n-2,dp);
        return dp[n];
    }
}