class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i < n; i++){
            if(notPrime[i]){
                continue;
            }
            
            count++;
            for(long j = (long)(i)*i; j < n; j += i){
                notPrime[(int)j] = true;
            }   
        }
        return count;
    }
}