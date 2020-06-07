class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int presum = nums[0];
        int max = presum;
        for(int i = 1; i < nums.length; i++) {
            if(presum > 0){
                presum += nums[i];
            }else{
                presum = nums[i];
            }
            max = Math.max(presum, max);
        }
        return max;
    }
}