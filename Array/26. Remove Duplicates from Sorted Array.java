class Solution {
    public int removeDuplicates(int[] nums) {
        int bias = 0;
        int ptr = 1;
        while(ptr + bias < nums.length){
            nums[ptr] = nums[ptr + bias];
            if(nums[ptr] == nums[ptr-1]){
                bias++;
            }else{
                ptr++;
            }
        }
        return nums.length - bias;
    }
}