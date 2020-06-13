class Solution {
    // Boyer-Moore Majority Vote Algorithm
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int majority = nums[0];
        for(int num : nums){
            majority = cnt>0 ? majority:num;
            cnt = num==majority? cnt+1:cnt-1;
        }
        return majority;
    }
}