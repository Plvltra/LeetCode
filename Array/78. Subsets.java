class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null)
            return new ArrayList<>();
        
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<>());
        
        for(int i = 0; i<nums.length; i++){
            expendSets(sets, nums[i]);
        }
        return sets;
    }
    
    private void expendSets(List<List<Integer>> sets, int num){
        int size = sets.size();
        for(int i=0; i<size; i++){
            List<Integer> subset = new ArrayList(sets.get(i));
            subset.add(num);
            sets.add(subset);
        }
    }
}