class Solution {
    
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return Arrays.asList();
        
        Queue<String> combinations = new LinkedList<>();
        combinations.add("");
        for(int i = 0; i < digits.length(); i++){
            int size = combinations.size();
            while(size-- > 0){
                String top = combinations.poll();
                int digit = digits.charAt(i) - '0';
                char[] chars = map[digit].toCharArray();
                for(char c : chars){
                    combinations.add(top + c);
                }
            }
        }
        
        List<String> ans = new ArrayList<>();
        while(!combinations.isEmpty()){
            ans.add(combinations.poll());
        }
        return ans;
    }
}