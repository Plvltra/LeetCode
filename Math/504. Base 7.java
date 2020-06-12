class Solution {
    public String convertToBase7(int num) {
        boolean isNegative = num < 0;
        if(isNegative){
            num = -num;
        }
        
        StringBuilder sb = new StringBuilder();
        do{
            sb.append(num % 7);
            num = num / 7;
        }while(num != 0);
        
        if(isNegative){
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}