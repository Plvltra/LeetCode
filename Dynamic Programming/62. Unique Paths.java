class Solution {
    public int uniquePaths(int m, int n) {

        int[] paths = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i>0 && j>0){
                    paths[j] = paths[j] + paths[j-1];
                }else if(i>0 && j==0){
                    paths[j] = paths[j];
                }else if(i==0 && j>0){
                    paths[j] = paths[j-1];
                }else{
                    paths[j] = 1;
                }
            }
        }
        return paths[n-1];
    }
}