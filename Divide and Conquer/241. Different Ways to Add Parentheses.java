class Solution {
	private static List<Integer> computeList(
			List<Integer> lvalues, List<Integer> rvalues, char opr) {
		
		List<Integer> ans = new ArrayList<>();
		for(int lvalue:lvalues){
            for(int rvalue:rvalues){
                switch(opr){
                    case '+':
                    	ans.add(lvalue + rvalue);
                        break;  
                    case '-':
                    	ans.add(lvalue - rvalue);
                        break;
                    case '*':
                    	ans.add(lvalue * rvalue);
                        break;
                }
            }
        }
		return ans;
	}
	
	
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char opr = input.charAt(i);
            if(opr == '+' || opr == '-' || opr == '*'){
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> lvalues =  diffWaysToCompute(left);
                List<Integer> rvalues =  diffWaysToCompute(right);
                List<Integer> ways = computeList(lvalues, rvalues, opr);
                ans.addAll(ways);
            }
        }
        
        if(ans.size() == 0){
        	ans.add(Integer.parseInt(input));
        }
        return ans;
    }
}