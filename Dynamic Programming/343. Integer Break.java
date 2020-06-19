class Solution {
    public int integerBreak(int n) {
        int[] product = new int[n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j<i;j++){
                int prod = Math.max(j, product[j]) * Math.max(i-j, product[i-j]);
                product[i] = Math.max(product[i], prod);
            }
        }
        return product[n];
    }
}