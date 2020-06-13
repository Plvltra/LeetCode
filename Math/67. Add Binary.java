class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(carry == 1 || i>=0 || j>=0){
            if(i>=0 && a.charAt(i--) == '1')
                carry++;
            if(j>=0 && b.charAt(j--) == '1')
                carry++;
            sb.append(carry & 1);
            carry = carry >> 1;
        }
        return sb.reverse().toString();
    }
}