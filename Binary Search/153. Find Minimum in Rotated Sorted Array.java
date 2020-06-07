class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        // loop invariant: ans in [lo, hi]
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] < nums[hi]){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return nums[lo];
    }
}