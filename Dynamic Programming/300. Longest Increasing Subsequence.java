class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] longest = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]){
                    longest[i] = Math.max(longest[i], longest[j]);   
                }
            }
            longest[i] = longest[i] + 1;
        }
        
        int ans = 0;
        for(int length : longest){
            ans = Math.max(ans, length);
        }
        return ans;
    }
}