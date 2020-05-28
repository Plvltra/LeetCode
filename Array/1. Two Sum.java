//original O(n^2) + O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Input Error");
    }
}

//improved O(n) + O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< nums[].ength; i++) {
            map.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new nums[]{i, map.get(comlpement)};
            }
        }
        throw new IllegalArgumentException("Input Error");
    }
}