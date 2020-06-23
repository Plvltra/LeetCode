class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i<=s.length(); i++){
            for(String word : wordDict){
                int len = word.length();
                if(len <= i && s.substring(i-len, i).equals(word)){
                    if(dp[i-len]){
                        dp[i] = true;   
                    }
                }
            }
        }
        return dp[s.length()];
    }
}