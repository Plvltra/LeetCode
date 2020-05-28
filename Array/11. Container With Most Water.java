class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int maxproduce = 0;
        while(l < r){
            int produce = (r-l)*Math.min(height[l],height[r]);
            maxproduce = Math.max(maxproduce,produce);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxproduce;
    }
}