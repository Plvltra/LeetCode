class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n){
        int total = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                int pre = i==0? 0 : flowerbed[i-1];
                int next = i==flowerbed.length?0 : flowerbed[i+1];
                if(pre==0 && next==0){
                    flowerbed[i] = 1;
                    total++;
                }
            }
        }
        return total>=n;
    }
}