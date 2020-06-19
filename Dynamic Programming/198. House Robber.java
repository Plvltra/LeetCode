class Solution {
    public int rob(int[] nums) {
        int pre1 = 0;
        int pre2 = 0;
        for(int i = 0; i<nums.length; i++){
            int max = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = max;
        }
        return pre1;
    }
}