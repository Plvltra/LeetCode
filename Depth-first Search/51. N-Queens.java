class Solution {
    private int n;
    private int[][] lock;
    private List<List<String>> solutions;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        lock = new int[n][n];
        solutions = new ArrayList<>();
        dfs(0);
        return solutions;
    }
    
    public void dfs(int r){
        if(r == n){
            List<String> solution = toSolution(lock);
            solutions.add(solution);
            return;
        }
        
        for(int c = 0; c < n; c++){
            if(lock[r][c] == 0){
                changeStatus(r,c,true);
                dfs(r+1);
                changeStatus(r,c,false);
            }   
        }
    }
    
    private void changeStatus(int r, int c, boolean addLock){
        int num = addLock? 1 : -1;
        for(int i = 0; i<n; i++){
            if(i != c)
                lock[r][i] += num;
            if(i != r)
                lock[i][c] += num;
        }
        int nr = r+1; 
        int nc = c+1;
        while(isLegal(nr, nc))
            lock[nr++][nc++] += num;
        nr = r+1; 
        nc = c-1;
        while(isLegal(nr, nc))
            lock[nr++][nc--] += num;
    }
    
    private boolean isLegal(int r, int c){
        return 0<=r && r<n && 0<=c && c<n;
    }
    
    private List<String> toSolution(int[][] lock){
        List<String> solution = new ArrayList<>();
        for(int r = 0; r<n; r++){
            StringBuilder sb = new StringBuilder();
            for(int c = 0; c < n; c++){
                if(lock[r][c] == 0){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            solution.add(sb.toString());
        }
        return solution;
    }
}

// 更加巧妙，添加colUsed45,135度Used数组,改变棋盘占用状态
// private List<List<String>> solutions;
// private char[][] nQueens;
// private boolean[] colUsed;
// private boolean[] diagonals45Used;
// private boolean[] diagonals135Used;
// private int n;

// public List<List<String>> solveNQueens(int n) {
//     solutions = new ArrayList<>();
//     nQueens = new char[n][n];
//     for (int i = 0; i < n; i++) {
//         Arrays.fill(nQueens[i], '.');
//     }
//     colUsed = new boolean[n];
//     diagonals45Used = new boolean[2 * n - 1];
//     diagonals135Used = new boolean[2 * n - 1];
//     this.n = n;
//     backtracking(0);
//     return solutions;
// }

// private void backtracking(int row) {
//     if (row == n) {
//         List<String> list = new ArrayList<>();
//         for (char[] chars : nQueens) {
//             list.add(new String(chars));
//         }
//         solutions.add(list);
//         return;
//     }

//     for (int col = 0; col < n; col++) {
//         int diagonals45Idx = row + col;
//         int diagonals135Idx = n - 1 - (row - col);
//         if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx]) {
//             continue;
//         }
//         nQueens[row][col] = 'Q';
//         colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = true;
//         backtracking(row + 1);
//         colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = false;
//         nQueens[row][col] = '.';
//     }
// }