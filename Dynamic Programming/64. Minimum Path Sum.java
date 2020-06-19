class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null){
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[] rpre = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i>0 && j>0){
                    rpre[j] = Math.min(rpre[j], rpre[j-1]);
                }else if(i==0 && j>0){
                    rpre[j] = rpre[j-1];
                }else if(i>0 && j==0){
                    rpre[j] = rpre[j];
                }else {
                    rpre[j] = 0;
                }
                rpre[j] += grid[i][j];
            }   
        }
        return rpre[n-1];
    }
}