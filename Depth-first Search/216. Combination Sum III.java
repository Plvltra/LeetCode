class Solution {
    private int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private List<List<Integer>> combinations;
        
    public List<List<Integer>> combinationSum3(int k, int n) {
        //corner 
        combinations = new ArrayList<>();
        dfs(new ArrayList<>(), 0, k, n);
        return combinations;
    }
    
    private void dfs(List<Integer> combination, int start, int count, int target){
        if(target == 0 && count==0){
            combinations.add(new ArrayList(combination));
            return;
        }
        
        for(int i = start; i != candidates.length; i++){
            int minSum = candidates[i] * count;
            int maxSum = candidates[candidates.length-1] * count;
            boolean canReach = minSum <= target && maxSum >= target;
            if(!canReach){
                return;
            }
            
            combination.add(candidates[i]);
            dfs(combination, i + 1, count - 1, target - candidates[i]);
            combination.remove(combination.size() - 1);        
        }
    }
    
}