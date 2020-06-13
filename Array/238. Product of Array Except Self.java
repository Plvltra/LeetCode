class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        Arrays.fill(product, 1);
        int rproduct = 1;
        for(int i = n-1; i>=0; i--){
            product[i] *=  rproduct;
            rproduct *= nums[i];
        }
        int lproduct = 1;
        for(int i = 0 ; i < n; i++){
            product[i] *=  lproduct;
            lproduct *= nums[i];
        }
        return product;
    }
}
