class Solution {
    public int numSquares(int n) {
        int[] count = new int[n+1];
        for(int i = 0; i < count.length; i++){
            count[i] = i;
        }
        
        for(int target = 1; target<=n; target++){
            int maxFactor = (int)Math.sqrt(target);
            for(int i = maxFactor; i>=1; i--){
                int time = count[target - i*i] + 1;
                count[target] = Math.min(time, count[target]);
            }
        }
        return count[n];
    }
}