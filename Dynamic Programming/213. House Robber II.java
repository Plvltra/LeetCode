class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
            
        int amount1 = robLine(nums, 0, nums.length - 2);
        int amount2 = robLine(nums, 1, nums.length - 1);
        return Math.max(amount1, amount2);
    }
    
    private int robLine(int[] nums, int start, int end){
        int pre2 = 0;
        int pre1 = 0;
        for(int i = start; i <= end; i++){
            int temp = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = temp;
        }
        return pre1;
    }    
}