class Solution {
    public static int losearch(int[] nums, int s, int e, int target){
        if(!(s >= 0 && s < nums.length && e >= 0 && e < nums.length && s<=e)){
            return -1;
        }
        
        while(s <= e){
            int m = (s + e) /2;
            if(nums[m] < target){
                s = m + 1;
            }else if(nums[m] > target){
                e = m - 1;
            }else{
                if(m-1 >= 0 && nums[m-1] == nums[m]){
                    e = m -1;
                }else{
                    return m;
                }
            }
        }
        return -1;
    }
    
    public static int hisearch(int[] nums, int s, int e, int target){
        if(!(s >= 0 && s < nums.length && e >= 0 && e < nums.length && s<=e)){
            return -1;
        }
        
        while(s <= e){
            int m = (s + e) /2;
            if(nums[m] < target){
                s = m + 1;
            }else if(nums[m] > target){
                e = m - 1;
            }else{
                if(m+1 < nums.length && nums[m] == nums[m+1]){
                    s = m + 1;
                }else{
                    return m;
                }
            }
        }
        return -1;
    }
    
    
    public int[] searchRange(int[] nums, int target) {
        int lo = losearch(nums, 0, nums.length-1, target);
        int hi = lo==-1? -1 : hisearch(nums, 0, nums.length-1, target);
        return new int[]{lo, hi};
        
    }
}