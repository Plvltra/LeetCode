class Solution {
    private int distance[][] = new int[1000][1000];
    public int minDistance(String word1, String word2) {
        for(int i = 0; i <= word1.length(); i++){
            for(int j = 0; j <= word2.length(); j++){
                if(i==0 || j==0){
                    distance[i][j] = i + j;
                }else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    distance[i][j] = distance[i-1][j-1];
                }else{
                    distance[i][j] = 1 + Math.min(distance[i][j-1], distance[i-1][j]);
                }
            }
        }
        return distance[word1.length()][word2.length()];
    }
}