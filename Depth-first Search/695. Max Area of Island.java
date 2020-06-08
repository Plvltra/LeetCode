class Solution {
    
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private int dfs(int[][] grid, int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length){
            return 0;
        }
        
        if(grid[r][c] == 0){
            return 0;
        }else{
            grid[r][c] = 0;
            int count = 1;
            for(int[] dir : direction){
                count += dfs(grid, r+dir[0], c+dir[1]);
            }
            return count;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }
}