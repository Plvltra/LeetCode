class Solution {
    public boolean isPerfectSquare(int num) {
        int square = 0;
        int gap = 1;
        while(0 <= square && square <num){
            square += gap;
            gap += 2;
        }
        return square == num;
    }
}