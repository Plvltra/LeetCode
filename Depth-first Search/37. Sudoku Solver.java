class Solution {
    private static final int n = 9;
    private static final int boardSize = n*n;
    private static final char empty = '.';
    private static final Character[] options = {'1','2','3','4','5','6','7','8','9'};
    
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }
    
    private boolean dfs(char[][] board, int id){
        if(id == boardSize){
            return true;
        }
        
        final int r = id / n;
        final int c = id - n*r;
        if(board[r][c] != empty){
            return dfs(board, id + 1);
        }else{
            Set<Character> choices = findChoices(board, r, c);
            for(char choice : choices){
                board[r][c] = choice;
                if(dfs(board, id + 1)){
                    return true;
                }
                board[r][c] = empty;
            }
            return false;
        }
    }
    
    private Set<Character> findChoices(char[][] board, int r, int c) {
        Set<Character> rowset = numset(board, r, 0, 1, n); 
        Set<Character> colset = numset(board, 0, c, n, 1);
        final int boxLength = 3;
        int boxR = r / boxLength * boxLength;
        int boxC = c / boxLength * boxLength;
        Set<Character> boxset = numset(board, boxR, boxC, 3, 3);
        
        Set<Character> ans = new HashSet(Arrays.asList(options)); 
        ans.removeAll(rowset);
        ans.removeAll(colset);
        ans.removeAll(boxset);
        return ans;
    }
    
    private Set<Character> numset(char[][] board, int r, int c, int rLength, int cLength){
        Set<Character> ans = new HashSet<>();
        for(int i = 0; i < rLength; i++){
            for(int j = 0; j < cLength; j++){
                if(board[r+i][c+j] != empty){
                    ans.add(board[r+i][c+j]);
                }
            }   
        }
        return ans;
    }
}

// BETTER SOLUTION

// private boolean[][] rowsUsed = new boolean[9][10];
// private boolean[][] colsUsed = new boolean[9][10];
// private boolean[][] cubesUsed = new boolean[9][10];
// private char[][] board;

// public void solveSudoku(char[][] board) {
//     this.board = board;
//     for (int i = 0; i < 9; i++)
//         for (int j = 0; j < 9; j++) {
//             if (board[i][j] == '.') {
//                 continue;
//             }
//             int num = board[i][j] - '0';
//             rowsUsed[i][num] = true;
//             colsUsed[j][num] = true;
//             cubesUsed[cubeNum(i, j)][num] = true;
//         }
//         backtracking(0, 0);
// }

// private boolean backtracking(int row, int col) {
//     while (row < 9 && board[row][col] != '.') {
//         row = col == 8 ? row + 1 : row;
//         col = col == 8 ? 0 : col + 1;
//     }
//     if (row == 9) {
//         return true;
//     }
//     for (int num = 1; num <= 9; num++) {
//         if (rowsUsed[row][num] || colsUsed[col][num] || cubesUsed[cubeNum(row, col)][num]) {
//             continue;
//         }
//         rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = true;
//         board[row][col] = (char) (num + '0');
//         if (backtracking(row, col)) {
//             return true;
//         }
//         board[row][col] = '.';
//         rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = false;
//     }
//     return false;
// }

// private int cubeNum(int i, int j) {
//     int r = i / 3;
//     int c = j / 3;
//     return r * 3 + c;
// }