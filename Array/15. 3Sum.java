class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2; i++) {
            if((nums[i] <= 0) && (i==0 || nums[i] != nums[i-1])){
                int target = 0 - nums[i];
                int j = i+1;
                int k = nums.length - 1;
                while(j < k){
                    int sum = nums[j] + nums[k];
                    if(sum < target){
                        j++;
                    }else if(sum > target){
                        k--;
                    }else{
                        List<Integer> newadd = Arrays.asList(nums[i], nums[j], nums[k]);
                        ans.add(newadd);
                        while(j+1<nums.length && nums[j+1] == nums[j]) j++;
                        while(k-1>=0 && nums[k-1] == nums[k]) k--;
                        j++;
                        k--;
                    }
                }   
            }
        }
        return ans;
    }
}