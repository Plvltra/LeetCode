class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        do{
            n = n - 1;
            sb.append((char)(n%26 + 'A'));
            n = n / 26;
        }while(n>0);
        return sb.reverse().toString();
    }
}