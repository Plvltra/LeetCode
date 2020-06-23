class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] used = new int[len][2];
        for(int i = 0; i < len; i++){
            String s = strs[i];
            for(char c:s.toCharArray()){
                if(c == '0'){
                    used[i][0]++;
                }else{
                    used[i][1]++;
                }
            }
        }
        
        int[][] maxForm = new int[m+1][n+1];
        for(int i = 0; i < len; i++){
            for(int j = m; j>=0; j--){
                for(int k = n; k>=0; k--){
                    int notUseI = maxForm[j][k];
                    int useI = 0;
                    if(j - used[i][0] >= 0 && k - used[i][1] >= 0){
                        useI = 1 + maxForm[j - used[i][0]][k - used[i][1]];    
                    }
                    maxForm[j][k] = Math.max(notUseI, useI);
                }
            }
        }
        return maxForm[m][n];
    }
}