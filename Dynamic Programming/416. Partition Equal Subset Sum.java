class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = Arrays.stream(nums).sum();
//         if(sum%2 != 0){
//             return false;
//         }
        
//         int n = nums.length;
//         int target = sum/2;
//         boolean[][] useup = new boolean[n + 1][target + 1];
//         for(int i = 1; i <= n; i++){
//             for(int j = 1; j <= target; j++){
//                 if(nums[i-1] < j){
//                     useup[i][j] = useup[i-1][j] || useup[i-1][j-nums[i-1]];
//                 }else if(nums[i-1] > j){
//                     useup[i][j] = useup[i-1][j];
//                 }else{
//                     useup[i][j] = true;
//                 }
//             }
//         }
//         return useup[n][target];
//     }
    
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 != 0){
            return false;
        }
        
        int n = nums.length;
        int target = sum/2;
        boolean[] useup = new boolean[target + 1];
        for(int i = 1; i <= n; i++){
            for(int j = target; j >= 1; j--){
                if(nums[i-1] < j){
                    useup[j] = useup[j] || useup[j-nums[i-1]];
                }else if(nums[i-1] > j){
                    useup[j] = useup[j];
                }else{
                    useup[j] = true;
                }
            }
        }
        return useup[target];
    }
}