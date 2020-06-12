class Solution {
    private char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        do{
            sb.append(map[num & 0xf]);
            num = num >>> 4;
        }while(num != 0);
        return sb.reverse().toString();
    }
}