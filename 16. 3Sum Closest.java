class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 100;
        for(int i =0;i < nums.length -2; i++) {
            int j = i+1;
            int k = nums.length -1;
            int newtarget = target - nums[i]; 
            while(j < k){
                int sum = nums[j] + nums[k];
                if(sum == newtarget){
                    return target;
                }else{
                    int newdiff = Math.abs(newtarget-sum);
                    if(newdiff<diff){
                        diff = newdiff;
                        ans = nums[i] + sum;
                    }
                    
                    if(sum < newtarget){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}