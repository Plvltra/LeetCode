class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {        
        int step = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            step++;
            int size = q.size();    
            while(size-- > 0){
                String cur = q.poll();
                if(diff(cur, endWord) == 0){
                    return step;
                }
                
                Iterator<String> itr = wordList.iterator();
                while(itr.hasNext()){
                    String next = itr.next();
                    if(diff(cur, next) == 1){
                        q.add(next);
                        itr.remove();
                    }
                }
            }
        }
        return 0;
    }
    
    private static int diff(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;   
            }
        }
        return count;
    }
}