class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target < letters[0]){
            return letters[0];
        }
        if(target >= letters[letters.length - 1]){
            return letters[0];
        }
        
        // loop invariant: l < r && letters[l] <= target && target < letters[r]
        int l = 0;
        int r = letters.length - 1;
        while(l+1 < r){
            int mid = l + (r - l)/2;
            if(letters[mid] <= target){
                l = mid;
            }else{
                r = mid;
            }
        }
        return letters[r];
    }
}