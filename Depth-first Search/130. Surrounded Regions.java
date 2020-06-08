class Solution {
    private int m,n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null){
            return;
        }
        m = board.length;
        n = board[0].length;
        for(int i = 0; i<m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for(int j = 0; j<n; j++){
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }
        postprocess(board);
    }
    
    private void dfs(char[][] board, int r, int c){
        if(r<0|| r>=m || c<0 || c>=n || board[r][c]!='O'){
            return;
        }
        board[r][c] = 'B';
        for(int[] dir: direction){
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
    
    private void postprocess(char[][] board){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'B'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
}