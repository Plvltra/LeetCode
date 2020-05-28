class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int s = 0;
        int e = m;
        int totalNum = m + n;
        while(s <= e){
            int i = (s+e)/2;
            int j = totalNum/2 - i;

            // i > 0 => j < n
            if(i>0 && nums1[i-1] > nums2[j]){
                e = i-1;
            // i < m => j  > 0
            }else if(i<m && nums2[j-1] > nums1[i]){
                s = i+1;
            }
            else{
                double maxleft = 0;
                double minright = 0;
                if(totalNum % 2 == 0){
                    if(i == 0){
                        maxleft = nums2[j-1];
                    }else if(j ==0){
                        maxleft = nums1[i-1];
                    }else{
                        maxleft = Math.max(nums1[i-1],nums2[j-1]);
                    }
                    if(i == m){
                        minright = nums2[j];
                    }else if(j == n){
                        minright = nums1[i];
                    }else{
                        minright = Math.min(nums1[i], nums2[j]);
                    }
                    return (maxleft + minright)/2.0;
                }else{
                    // sometimes minright not exists
                    if(i == m){
                        minright = nums2[j];
                    }else if(j == n){
                        minright = nums1[i];
                    }else{
                        minright = Math.min(nums1[i], nums2[j]);
                    }
                    return minright;
                }
            }   
        }
        return 0.0;
    }
    
}