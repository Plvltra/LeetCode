class Solution {
    public int change(int amount, int[] coins) {
        // dp(n, amount) = dp(n-1,amount) + dp(n, amount-value) 
        // dp(any, 0) = 1;
        // dp(0, any) = 0;
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int value : coins){
            for(int j = 0; j <= amount; j++){
                if(j - value >=0){
                    dp[j] += dp[j-value]; 
                }
            }
        }
        return dp[amount];
    }
}