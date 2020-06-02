
// LeetCode75. Sort Colors
class Solution {
	
//	参考https://www.jianshu.com/p/d70aeccaee19
//	与快速排序partition同理
	
//	对于每次切分：从数组的左边到右边遍历一次，维护三个指针lt,gt i作为不变式，其中
//	lt指针使得元素[0, lt)]的值均小于切分元素；
//	gt指针使得元素[gt, length)的值均大于切分元素；
//	i指针使得元素[lt, i)的值均等于切分元素，
//	[i, gt]的元素还没被扫描，切分算法执行到i>=gt为止。
    public void sortColors(int[] nums) {
        int lt = 0;
        int gt = nums.length;
        int i = 0;
        while(i < gt){
            if(nums[i] == 0){
                swap(nums, lt++, i++);
            }else if(nums[i] == 1) {
                i++;
            }else{
                swap(nums, --gt, i);
            }
        }
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}