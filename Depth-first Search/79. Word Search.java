class Solution {
    private static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || word == null){
            return false;
        }
        
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(dfs(board, word, i, j))
                   return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c) {
        if(word.length() == 0){
            return true;
        }
        if(r<0 || r>=m || c<0 || c>=n){
            return false;
        }
        
        if(board[r][c]== word.charAt(0)){
            char save = board[r][c];
            board[r][c] = '?';
            String nextword = word.substring(1, word.length());
            for(int[] dir : direction){
                int nr = r+dir[0];
                int nc = c+dir[1];
                if(dfs(board, nextword, nr, nc)){
                    return true;
                }
            }
            board[r][c] = save;
        }
        return false;
    }
}