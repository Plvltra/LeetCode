class Solution {
    private List<List<Integer>> combinations;
        
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0){
            return new ArrayList<>();
        }
        
        combinations = new ArrayList<>();
        boolean[] hasVisited = new boolean[n+1];
        dfs(new ArrayList<>(), 1, n, k);
        return combinations;
    }
    
    private void dfs(List<Integer> preCombine, int start, int n, int k){
        if(k==0){
            combinations.add(new ArrayList(preCombine));
            return;   
        }
        
        for(int i = start; i <= n-k+1; i++){
            preCombine.add(i);
            dfs(preCombine, i+1, n, k-1);
            preCombine.remove(preCombine.size() -1);    
        }
    }
}