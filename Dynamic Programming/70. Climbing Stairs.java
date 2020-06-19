class Solution {
    public int climbStairs(int n) {
        if(n<=2)
            return n;
        int dp1 = 1;
        int dp2 = 2;
        for(int i = 3; i <= n; i++){
            dp2 = dp1 + dp2;
            dp1 = dp2 - dp1;
        }
        return dp2;
    }
}