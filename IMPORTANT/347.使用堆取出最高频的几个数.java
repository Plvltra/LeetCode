class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(Integer key : nums){
    		Integer frequency = map.getOrDefault(key, 0) + 1;
    		map.put(key, frequency);    		
    	}
    	// 小顶堆
    	Queue<Integer> queue = new PriorityQueue<>(
    			(num1, num2) -> map.get(num1) - map.get(num2));
    	for(Integer key : map.keySet()) {
    		queue.add(key);
    		if(queue.size() > k)
    			queue.poll();
    	}
    	
    	int[] ans = new int[k];
    	for(int i = 0;i <k;i++) {
    		ans[i] = queue.poll();
    	}
    	return ans;
    }
}