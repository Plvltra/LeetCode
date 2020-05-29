class Solution {
    
    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray(); 
        while(l < r){
            while(l < r && !vowels.contains(arr[l]+"")) l++;
            while(l < r && !vowels.contains(arr[r]+"")) r--;
            swap(arr, l, r);
            l++;
            r--;
        }
        return new String(arr);
    }
}