class Solution {
    private int m,n;
    private int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    
    private boolean dfs(char[][] grid, int r, int c){
        if(r<0||r>=m||c<0||c>=n || grid[r][c]=='0'){
            return false;
        }
        
        grid[r][c] = '0';
        for(int[] dir: direction){
            dfs(grid, r+dir[0], c+dir[1]);
        }
        return true;
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i =0; i<m;i++){
            for(int j=0; j<n; j++){
                 if(dfs(grid, i, j))
                     count++;
            }
        }
        return count;
    }
}