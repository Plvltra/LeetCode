class Solution {
    // O(m+n)
    public static boolean partOf(String s, String word) {
        int sLen = s.length();
        int wordLen = word.length();
        if(sLen < wordLen){
            return false;
        }
        
        int wptr = 0;
        for(int sptr = 0; sptr < sLen && wptr < wordLen; sptr++) {
            if(s.charAt(sptr) == word.charAt(wptr)){
                wptr++;
            }
        }
        return wptr == wordLen;
    }
    
    //O(m+n)
    public String greater(String a, String b){
        int aLen = a.length();
        int bLen = b.length();
        if(aLen != bLen){
            return aLen > bLen ? a : b;
        }else{
            return a.compareTo(b) < 0 ? a : b;
        }
    }
    
    // O(n)
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for(String word : d){
            if(partOf(s, word)){
                ans = greater(ans, word);
            }
        }
        return ans;
    }
}