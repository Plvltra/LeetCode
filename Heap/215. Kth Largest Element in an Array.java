class Solution {
    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private static int partition(int[] nums, int left, int right){
        // Partition1
        // int pivot = nums[right];
        // int i = left;
        // int j = right;
        // while(i < j) {
        //     while(i < j && nums[i] >= pivot) i++;
        //     while(i < j && nums[j] <= pivot) j--;
        //     if(i < j){
        //         swap(nums, i, j);
        //     }
        // }
        // swap(nums, i, right);
        // return i;
        
        // Partition2
        // int pivot = nums[left];
        // int i = left;
        // int j = right;
        // while(i < j) {
        //     while(i < j && nums[j] <= pivot) j--;
        //     while(i < j && nums[i] >= pivot) i++;
        //     if(i < j){
        //         swap(nums, i, j);
        //     }
        // }
        // swap(nums, j, left);
        // return j;
        
        // Partition3
        // int pivot = nums[right];
        // int slow = left;
        // for(int fast = left; fast <= right; fast++){
        //     if(nums[fast] > pivot){
        //         swap(nums, slow, fast);
        //         slow++;
        //     }
        // }
        // swap(nums, right, slow);
        // return slow;
        
        // Partition4
        int pivot = nums[left];
        int slow = left;
        for(int fast = left + 1; fast <= right; fast++){
            if(nums[fast] > pivot){
                slow++;
                swap(nums, slow, fast);
            }
        }
        swap(nums, left, slow);
        return slow;
    }
    
    public int findKthLargest(int[] nums, int k) {
        k = k-1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = partition(nums, left, right);
            if(mid == k){
                return nums[mid];
            }else if(mid < k){  
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        throw new IllegalArgumentException();
    }
}