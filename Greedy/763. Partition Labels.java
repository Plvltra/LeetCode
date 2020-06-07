class Solution {
    
    public List<Integer> partitionLabels(String S) {
        boolean[] used = new boolean[26];
        int sptr = 0;
        int eptr = sptr;
        List<Integer> ans = new ArrayList<>();
        while(sptr < S.length()){
            for(int i = sptr; i <= eptr; i++){
                char c = S.charAt(i);
                if(!used[c-'a']){
                    used[c-'a'] = true;
                    eptr = Math.max(eptr, S.lastIndexOf(c));    
                }
            }
            ans.add(eptr - sptr + 1);
            sptr = eptr+1;
            eptr = sptr;
        }
        return ans;
    }
}