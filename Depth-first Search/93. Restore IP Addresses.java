class Solution {
    
    private List<String> addrs;
    
    public List<String> restoreIpAddresses(String s) {
        addrs = new ArrayList<>();
        if(s == null){
            return addrs;
        }
        
        dfs(new StringBuilder(),s, 0, 4);
        return addrs;
    }
    
    private void dfs(StringBuilder prefix, final String s, int start, int rest){
        if(rest == 0 || start == s.length() || 3*rest < s.length()-start){
            if(rest == 0 && start == s.length()){
                addrs.add(prefix.substring(0, prefix.length()-1));
            }
            return;
        }
        
        for(int len = 1; len <= 3 && start+len <=s.length(); len++){
            String numstr = s.substring(start, start+len);
            if(isLegal(numstr)){
                int oldLen = prefix.length();
                prefix.append(numstr + ".");
                dfs(prefix, s, start+len, rest-1);
                prefix.delete(oldLen, prefix.length());
            }else{
                return;
            }
        }
    }
    
    private boolean isLegal(String numstr){
        if(numstr.charAt(0) == '0' && numstr.length() >= 2){
            return false;
        }else{
            int num = Integer.parseInt(numstr);
            return 0 <= num && num <= 255;
        }
    }
}