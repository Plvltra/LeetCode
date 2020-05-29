class Solution {
    public boolean judgeSquareSum(int c) {
        int min = 0;
        int max = (int)Math.sqrt(c);
        while(min <= max){
            int sum = min*min + max*max;
            if(sum < c){
                min++;
            }else if(sum > c){
                max--;
            }else{
                return true;
            }
        }
        return false;
    }
}