class Solution {
    public int minMoves2(int[] nums) {
        shuffle(nums);
        int target = quickSelect(nums, 0, nums.length-1, nums.length/2);
        int min = 0;
        for(int i = 0 ; i < nums.length; i++){
            min += Math.abs(target-nums[i]);
        }
        return min;
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int slow = start;
        int fast = start;
        while(fast <= end){
            if(nums[fast] < pivot){
                swap(nums, slow++, fast);
            }
            fast++; 
        }
        swap(nums, slow, end);
        
        if(slow == k){
            return nums[k];
        }else if(slow <k){
            return quickSelect(nums, slow + 1, end, k);    
        }else{
            return quickSelect(nums, start, slow-1, k);
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private void shuffle(int a[]) {
        Random random = new Random();
        for(int i = 1; i < a.length; i++) {
            int r = random.nextInt(i + 1);
            swap(a, i, r);
        }
    }
}