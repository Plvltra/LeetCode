class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        
        int max = 0;
        int low = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > low){
                max += prices[i] - low;
            }
            low = prices[i];
        }
        return max;
    }
}