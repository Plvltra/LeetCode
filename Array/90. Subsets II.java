class Solution {
    private List<List<Integer>> subsets;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //
        subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        findSubsets(new ArrayList<>(), nums, 0);
        return subsets;
    }
    
    private void findSubsets(List<Integer> tempSet, int[] nums, final int start) {
        for(int i = start; i < nums.length; i++) {
            boolean repeatBranch = i > start && nums[i] == nums[i-1];
            if(!repeatBranch){
                tempSet.add(nums[i]);
                subsets.add(new ArrayList(tempSet));
                findSubsets(tempSet, nums, i+1);
                tempSet.remove(tempSet.size()-1);
            }
        }
    }
}