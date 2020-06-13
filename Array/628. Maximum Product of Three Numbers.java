class Solution {
    public int maximumProduct(int[] nums) {
        int max1, max2, max3, min1, min2;
        max1 = Integer.MIN_VALUE;
        max2 = Integer.MIN_VALUE;
        max3 = Integer.MIN_VALUE;
        min1 = Integer.MAX_VALUE;
        min2 = Integer.MAX_VALUE;
        for(int num : nums){
            if(max1 < num && num <= max2){
                max1 = num;
            }else if(max2 < num && num <= max3){
                max1 = max2;
                max2 = num;
            }else if(max3 < num){
                max1 = max2;
                max2 = max3;
                max3 = num;
            }
            
            if(min2 <= num && num < min1){
                min1 = num;
            }else if(num < min2){
                min1 = min2;
                min2 = num;
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max3);
    }
}