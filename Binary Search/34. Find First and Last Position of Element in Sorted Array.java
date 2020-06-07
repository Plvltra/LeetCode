class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
            
        int first = firstIndex(nums, target);
        first = nums[first] != target? -1 : first;
        int last = lastIndex(nums, target);
        last = nums[last] != target? -1 : last;
        return new int[]{first, last};
    }
    
    static int firstIndex(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] <target){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
    
    static int lastIndex(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo)/2 + 1;
            if(nums[mid] <=target){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }
}