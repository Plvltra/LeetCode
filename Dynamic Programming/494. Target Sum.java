class Solution {
//     1.Recursion version
//     public int findTargetSumWays(int[] nums, int S) {
//         return dp(nums, nums.length, S);
//     }
    
//     private int dp(int[] nums, int n, int S){
//         if(n==0 && S==0){
//             return 1;
//         }else if(n==0 && S!=0){
//             return 0;
//         }
//         return dp(nums, n-1, S+nums[n-1]) + dp(nums, n-1, S-nums[n-1]);
//     }

//     2.DP with O(n^2)Space
//     public int findTargetSumWays(int[] nums, int S) {
//         int sum = Arrays.stream(nums).sum();
//         if(S > sum || S < -sum){
//             return 0;
//         }
        
//         int bias = sum;
//         int n = nums.length;
//         int[][] dp = new int[n+1][bias+sum+1];
//         dp[0][bias] = 1;
//         for(int i = 1; i<= n; i++){
//             for(int j = -sum; j <= sum; j++){
//                 if(-sum <= j + nums[i-1] && j + nums[i-1] <= sum){
//                     dp[i][j+bias] += dp[i-1][j+nums[i-1] + bias];    
//                 }
//                 if(-sum <= j - nums[i-1] && j - nums[i-1] <= sum){
//                     dp[i][j+bias] += dp[i-1][j-nums[i-1]+bias];    
//                 }
//             }
//         }
//         return dp[n][S+bias];
//     }

// 3.DP with O(n)Space
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if(S > sum || S < -sum){
            return 0;
        }
        
        int bias = sum;
        int n = nums.length;
        int[] dp = new int[bias+sum+1];
        dp[bias] = 1;
        for(int i = 1; i<= n; i++){
            int[] next = new int[bias+sum+1];
            for(int j = -sum; j <= sum; j++){
                if(-sum <= j + nums[i-1] && j + nums[i-1] <= sum){
                    next[j+bias] += dp[j+nums[i-1] + bias];    
                }
                if(-sum <= j - nums[i-1] && j - nums[i-1] <= sum){
                    next[j+bias] += dp[j-nums[i-1]+bias];    
                }
            }
            dp = next;
        }
        return dp[S+bias];
    }
}