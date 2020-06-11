class Solution {
    private List<List<Integer>> combinations;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null){
            return new ArrayList<>();
        }
        combinations = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), 0, candidates, target);
        return combinations;
    }
    
    private void dfs(List<Integer> combination, int start, int[] candidates, int target) {
        if(target == 0){
            combinations.add(new ArrayList(combination));
            return;
        }
        
        int nextTarget = target - candidates[start];
        if(nextTarget >= 0){
            combination.add(candidates[start]);
            dfs(combination, start, candidates, nextTarget);
            combination.remove(combination.size()-1);       
            if(start+1 < candidates.length){
                dfs(combination, start+1, candidates, target);   
            }
        }
    }
}