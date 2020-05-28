class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>(); 
        final int n = nums.length;
        if(n < 4){
            return ans;
        }
        
        int leftMax = target%2 ==0? target /2 : (target-1) /2;
        int rightMin = target - leftMax;
        for(int i = 0; i <n-3; i++){
            for(int j = i+1; j<n-2; j++){
                int sum = nums[i] + nums[j];
                boolean notRepeat = (i==0 || nums[i] != nums[i-1]) && (j==i+1 || nums[j] != nums[j-1]);
                if(notRepeat && sum <= leftMax){
                    int k = j+1;
                    int l = n-1;
                    int target2 = target - sum;

                    while(k < l){
                        int sum2 = nums[k] + nums[l];
                        if(sum2 < rightMin){
                            k++;
                        }else{
                            if(sum2 < target2){
                                k++;
                            }else if(sum2 > target2){
                                l--;
                            }else{
                                ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                                while(k < l && nums[k] == nums[k+1]) k++;
                                while(l > k && nums[l] == nums[l-1]) l--;
                                k++;l--;
                            }   
                        }
                    }
                }
            }
        }
        return ans;
    }
}