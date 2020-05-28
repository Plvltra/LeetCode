class Solution {
    
    public static int bisearch(int[] nums, int s, int e, int target){
        while(s <= e){
            int middle = (s+e)/2;
            if(nums[middle] > target){
                e = middle - 1;
            }else if(nums[middle] < target){
                s = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        
        int lo = 0;
        int hi = n-1;
        while(lo < hi){
            int middle = (lo + hi) / 2;
            if(nums[middle] > nums[hi]){
                lo = middle + 1;
            }else {
                hi = middle;
            }
        }
        int delimeter = lo;
        
        int ans1 = bisearch(nums, 0, delimeter, target);
        int ans2 = bisearch(nums, delimeter, n-1, target);
        return Math.max(ans1, ans2);
    }
}