class Solution {
    // public int wiggleMaxLength(int[] nums) {
    //     int n = nums.length;
    //     if(n == 0){
    //         return 0;
    //     }
    //     int[] top = new int[n];
    //     int[] bottom = new int[n];
    //     for(int i = 0; i < nums.length; i++){
    //         for(int j = 0; j < i; j++){
    //             if(nums[j] < nums[i]){
    //                 top[i] = Math.max(top[i], bottom[j]);
    //             }else if(nums[j] > nums[i]){
    //                 bottom[i] = Math.max(bottom[i], top[j]);
    //             }
    //         }
    //         top[i]++;
    //         bottom[i]++;
    //     }
    //     return Math.max(top[n-1], bottom[n-1]);
    // }
    
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int top = 1;
        int bottom = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1] < nums[i]){
                top = bottom+1;
            }else if(nums[i-1] > nums[i]){
                bottom = top+1;
            }
        }
        return Math.max(top, bottom);
    }
}