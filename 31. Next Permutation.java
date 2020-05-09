class Solution {
    public static void swap(int[] nums, int a, int b){
        if(a < nums.length && b < nums.length){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }    
    }
    
    public static void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            swap(nums, lo, hi);
            lo++; hi--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return;
        }
        
        for(int i = n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]){
                int leastgreater = Integer.MAX_VALUE;
                int greaterIndex = -1;
                for(int j = i + 1; j < n; j++){
                    if(nums[j] > nums[i] && nums[j] <= leastgreater){
                        leastgreater = nums[j];
                        greaterIndex = j;
                    }
                }

                if(greaterIndex != -1){
                    swap(nums, i, greaterIndex);
                    reverse(nums, i+1, n-1);
                    return;
                }
            }
        }
        reverse(nums, 0, n-1);
    }
}