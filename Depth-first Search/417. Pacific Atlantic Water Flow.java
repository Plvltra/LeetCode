class Solution {
    private int m,n;
    private int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    private boolean[][] canFlowP;
    private boolean[][] canFlowA;
    
    private boolean isValid(int r, int c){
        return 0<=r && r<m && 0<=c && c<n;
    }
    
    private void dfs(int[][] matrix, int r, int c, boolean[][] canFlow){
        if(canFlow[r][c]){
            return;
        }
        
        canFlow[r][c] = true;
        for(int[] dir : direction){
            int nr = r+dir[0];
            int nc = c+dir[1];
            if(isValid(nr,nc) && matrix[r][c] <= matrix[nr][nc]){
                dfs(matrix, nr, nc, canFlow);
            }
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new ArrayList<>();
        }
        
        m = matrix.length;
        n = matrix[0].length;
        canFlowP = new boolean[m][n];
        canFlowA = new boolean[m][n];
        for(int i=0; i<m; i++){
            dfs(matrix, i, 0, canFlowP);
            dfs(matrix, i, n-1, canFlowA);
        }
        for(int j=0; j<n; j++){
            dfs(matrix, 0, j, canFlowP);
            dfs(matrix, m-1, j, canFlowA);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(canFlowP[i][j] && canFlowA[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}