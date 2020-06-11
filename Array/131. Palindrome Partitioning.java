class Solution {
    private List<List<String>> partitions;
    
    public List<List<String>> partition(String s) {
        if(s == null)
            return new ArrayList<>();
        
        partitions = new ArrayList<>();
        dfs(new ArrayList<>(), s, 0);
        return partitions;
    }
    
    private void dfs(List<String> tempPartition, String s, final int start) {
        if(start == s.length()){
            partitions.add(new ArrayList(tempPartition));
            return;
        }
        
        for(int end = start+1; end <= s.length(); end++){
            String toadd = s.substring(start, end);
            if(isPalindrome(toadd)){
                tempPartition.add(toadd);
                dfs(tempPartition, s, end);
                tempPartition.remove(tempPartition.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int begin = 0;
        int end = s.length() - 1;
        while(begin < end){
            if(s.charAt(begin++) != s.charAt(end--)){
                return false;
            }       
        }
        return true;
    }
}