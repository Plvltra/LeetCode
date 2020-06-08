class Solution {
    private int n;
    private boolean[] hasVisited;
    
    private void dfs(int[][] M, int stu){
        if(hasVisited[stu]){
            return;
        }
        
        hasVisited[stu] = true;
        int[] friends = M[stu];
        for(int i = 0; i < n; i++){
            if(friends[i] == 1){
                dfs(M, i);
            }
        }
    }
    
    public int findCircleNum(int[][] M) {
        n = M.length;
        hasVisited = new boolean[n];
        
        int count = 0;
        for(int i = 0; i<n; i++){
            if(!hasVisited[i]){
                dfs(M, i);
                count++;
            }
        }
        return count;
    }
}