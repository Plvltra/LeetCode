class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3){
            return 0;
        }
        int slices = 0;
        int count = 0;
        for(int i = 2; i<A.length; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                slices++;
                count+=slices;
            }else{
                slices = 0;
            }
        }
        return count;
    }
}