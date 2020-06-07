class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        // loop invariant: ans in [lo, hi)
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] != nums[mid + 1]){
                mid = mid + 1;
            }
            if((hi - mid)%2 == 1){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        return nums[lo];
    }
}