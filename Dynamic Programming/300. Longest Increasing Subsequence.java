class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] longest = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]){
                    longest[i] = Math.max(longest[i], longest[j]);   
                }
            }
            longest[i] = longest[i] + 1;
        }
        
        int ans = 0;
        for(int length : longest){
            ans = Math.max(ans, length);
        }
        return ans;
    }

//     O(N*lgN)
//     public int lengthOfLIS(int[] nums) {
//         int longest = 0;
//         int[] tails = new int[nums.length];
//         for(int i = 0; i < nums.length; i++){
//             int pos = binarySearch(tails, nums[i], longest);
//             tails[pos] = nums[i];
//             if(pos == longest)
//                 longest++;
//         }
//         return longest;
//     }
    
//     private int binarySearch(int[] arr, int num, int end){
//         int start = 0;
//         while(start < end){
//             int mid = start + (end-start)/2;
//             if(arr[mid] < num){
//                 start = mid + 1;
//             }else{
//                 end = mid;
//             }
//         }
//         return start;
//     }

}