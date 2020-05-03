class Solution {
    // original
    // public int removeElement(int[] nums, int val) {
    //     int ptr = 0;
    //     int bias = 0;
    //     while(ptr + bias < nums.length){
    //          nums[ptr] = nums[ptr+bias];
    //         if(nums[ptr] == val){
    //             bias++;
    //         }else{
    //             ptr++;
    //         }
    //     }
    //     return ptr;
    // }
    
    // solution 2
    // public int removeElement(int[] nums, int val) {
    //     int i = 0;
    //     for(int j = 0; j< nums.length; j++) {
    //         if(nums[j] != val){
    //             nums[i] = nums[j];
    //             i++;
    //         }
    //     }
    //     return i;
    // }
    
    public int removeElement(int[] nums, int val) {
        int elements = 0;
        for(int i = 0; i < nums.length - elements; ) {
            if(nums[i] == val){
                elements++;
                nums[i] = nums[nums.length - elements];
            }else{
                i++;
            }
        }
        return nums.length - elements;
    }
}