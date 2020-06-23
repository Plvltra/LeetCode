class Solution {
//     1. Ugly implement, DP with O(c*a) Space Complexity
//     public int coinChange(int[] coins, int amount) {
//         if(amount < 0){
//             return -1;
//         }
        
//         int n = coins.length;
//         int[] minCoins = new int[amount+1];
//         for(int i = 1; i <= amount; i++){
//             minCoins[i] = -1;
//         }
//         for(int value : coins){
//             for(int j = value; j <= amount; j++){
//                 if(minCoins[j - value] != -1){
//                     if(minCoins[j] == -1){
//                         minCoins[j] = minCoins[j-value]+1;
//                     }else{
//                         minCoins[j] = Math.min(minCoins[j], minCoins[j-value]+1);    
//                     }
//                 }
//             }
//         }
//         return minCoins[amount];
//     }

//     2. Better, still with O(c*a) Space Complexity,
//     Assume dp(n, amount) = min(1 + dp(n, amount-coins[n]) || dp(n-1, amount))
//     public int coinChange(int[] coins, int amount) {
//         if(amount < 0){
//             return -1;
//         }
//         int n = coins.length;
//         int[][] minCoins = new int[n+1][amount+1];
//         for(int i = 1; i <= amount; i++){
//             minCoins[0][i] = -1;
//         }
//         for(int i = 0; i < n; i++){
//             int value = coins[i];
//             for(int j = 0; j <= amount; j++){
//                 if(j < value){
//                     minCoins[i+1][j] = minCoins[i][j];
//                 }else{
//                     int useICount = minCoins[i+1][j-value];
//                     if(useICount != -1){
//                         useICount++;
//                     }   
//                     int noICount = minCoins[i][j];
//                     if(useICount != -1 && noICount != -1){
//                         minCoins[i+1][j] = Math.min(noICount, useICount);
//                     }else if(useICount == -1 && noICount != -1){
//                         minCoins[i+1][j] = noICount;
//                     }else if(useICount != -1 && noICount == -1){
//                         minCoins[i+1][j] = useICount;
//                     }else{
//                         minCoins[i+1][j] = -1;
//                     }
//                 }    
//             }
//         }
//         return minCoins[n][amount];
//     }
    
    public int coinChange(int[] coins, int amount) {
        if(amount < 0){
            return -1;
        }
        int n = coins.length;
        int[] minCoins = new int[amount+1];
        for(int i = 1; i <= amount; i++){
            minCoins[i] = -1;
        }
        for(int i = 0; i < n; i++){
            int value = coins[i];
            for(int j = value; j <= amount; j++){
                if(minCoins[j-value] != -1 && minCoins[j] != -1){
                    minCoins[j] = Math.min(1 + minCoins[j-value], minCoins[j]);
                }else if(minCoins[j-value] != -1 && minCoins[j] == -1){
                    minCoins[j] = 1 + minCoins[j-value];
                }
            }
        }
        return minCoins[amount];
    }

}
