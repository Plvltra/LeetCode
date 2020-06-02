class Solution {
	
    public String frequencySort(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	for(char c : s.toCharArray()){
    		Integer frequency = map.getOrDefault(c, 0) + 1;
    		map.put(c, frequency);    		
    	}
    	
    	Queue<Character> queue = new PriorityQueue<>(
    			(c1, c2) -> map.get(c2) - map.get(c1));
    	for(Character key : map.keySet()) {
    		queue.add(key);
    	}
    
    	String ans = "";
    	while (!queue.isEmpty()) {
			char c = queue.poll();
			int frequency = map.get(c);
			for(int i = 0; i < frequency; i++){
				ans += c;
			}
		}
		return ans;
    }
}