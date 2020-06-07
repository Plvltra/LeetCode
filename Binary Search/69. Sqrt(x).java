class Solution {
    
    public long bisearch(long target, long l, long r){
        long mid = (l+r)/2;
        if(mid*mid <= target && (mid+1)*(mid+1)>target){
            return mid;
        }else if(mid*mid > target){
            return bisearch(target, l, mid - 1);
        }else{
            return bisearch(target, mid + 1, r);
        }
    }
    
    public int mySqrt(int x) {
        return (int)bisearch(x,0,x);
    }
}