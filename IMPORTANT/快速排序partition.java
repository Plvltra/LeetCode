package zzx;

public class temp {

	private static int partition1(int[] arr, int left, int right) {
		int i = left;
		int j = right;
		int pivot = arr[right];
		while(i < j){
			// i j 遍历顺序决定边界
			while(i < j && arr[i] <= pivot) i++;
			while(i < j && arr[j] >= pivot) j--;
			if(i < j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}	
		arr[right] = arr[j];
		arr[j] = pivot;
		return i;
	}
	
//	可以想象两个小矮人都从左边向前出发
//	走后边的小矮人一遇到大蘑菇就蹲在那儿等
//	走前边的小矮人采到小蘑菇就回头跟后边的小矮人交换
//	所以后边的蘑菇都是小蘑菇,而前边都是大蘑菇
//	可以保证slow与fast之前全是大的数
	private static int partition2(int[] arr, int left, int right) {
		int slow = left;
		int pivot = arr[right];
		for(int fast = left; fast <= right; fast++) {
			if(arr[fast] < pivot) {
				int temp = arr[slow];
				arr[slow] = arr[fast];
				arr[fast] = temp;
				slow++;
			}
		}
		arr[right] = arr[slow];
		arr[slow] = pivot;
		return slow;
	}
	
	private static void qsort(int[] arr, int left, int right){
		if(left >= right)
			return;
		int mid = partition2(arr, left, right);
		qsort(arr, left, mid - 1);
		qsort(arr, mid + 1, right);
	}
	
	public static void qsort(int[] arr) {
		qsort(arr, 0, arr.length - 1);
	}
	
	static void testQsort(int[] arr) {
		qsort(arr);
		for(int num : arr){
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] nums1 = {3, 2};
		int[] nums2 = {5};
		int[] nums3 = {7, 6, 2, 1, 4};
		int[] nums4 = {7, 6, 3, 2, 1, 4};
		int[] nums5 = {7, 6, 5, 2, 1, 4};
		int[] nums6 = {7, 6, 5, 11, 1, 10};
		
//		testQsort(nums6);
		partition2(nums6, 0, 5);
		for(int num : nums6){
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
