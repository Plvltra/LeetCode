class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int decode1 = 1;
        int decode2 = 1;
        for(int i = n-1; i>=0; i--){
            int temp = 0;
            if(isLegal(s.substring(i,i+1)))
                temp += decode1;
            if(i+2<=n && isLegal(s.substring(i,i+2)))
                temp += decode2;
            decode2 = decode1;
            decode1 = temp;
        }
        return decode1;
    }
    
    private boolean isLegal(String s){
        if(1 <= s.length() && s.length() <= 2){
            if(s.length() == 2 && s.charAt(0) == '0'){
                return false;
            }
            int num = Integer.parseInt(s);
            return 1<=num && num<=26;
        }else{
            return false;
        }
    }
    
}