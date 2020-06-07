class Solution {
 
    static boolean isValid(int r, int c, int length) {
        return 0<=r && r<length && 0<=c && c<length;
    }
    
    static int bfs(int[][] grid) {
        int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int n = grid.length;
        
        int step = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        if(grid[0][0] == 0){
            q.add(new Pair<>(0, 0));
            grid[0][0] = 1;    
        }
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            while(size-- > 0){
                Pair<Integer, Integer> cur = q.poll();
                int cr = cur.getKey();
                int cc = cur.getValue();
                if(cr == n-1 && cc == n-1){
                    return step;
                }
                
                for(int[] dir : direction){
                    int nr = cr+dir[0];
                    int nc = cc+dir[1];
                    if(isValid(nr,nc,n) && grid[nr][nc] == 0){
                        q.add(new Pair<>(nr,nc));
                        grid[nr][nc] = 1;
                    }
                }   
            }        
        }
        return -1;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        return bfs(grid);
    }
}