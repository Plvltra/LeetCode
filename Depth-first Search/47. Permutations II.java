class Solution {
    private int n;
    private List<List<Integer>> permutations;
    private boolean[] hasVisited;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null){
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        n = nums.length;
        hasVisited = new boolean[nums.length];
        permutations = new ArrayList<>();
        dfs(nums, new LinkedList<>(), nums.length);
        return permutations;
    }
    
    private void dfs(int[] nums, List<Integer> prePermute,int rest){
        if(rest == 0){
            permutations.add(new ArrayList<>(prePermute));
            return;
        }
        
        int lastNum = nums[0] - 1;
        for(int i=0; i<n; i++){
            if(!hasVisited[i] && nums[i] != lastNum){
                lastNum = nums[i];
                hasVisited[i] = true;
                prePermute.add(nums[i]);
                dfs(nums, prePermute, rest-1);
                hasVisited[i] = false;
                prePermute.remove(prePermute.size() - 1);
            }
        }
    }
}