class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(Integer key : nums){
    		Integer frequency = map.getOrDefault(key, 0) + 1;
    		map.put(key, frequency);
    	}

    	List<Integer>[] buckets = new ArrayList[nums.length + 1];
    	for(Integer key : map.keySet()) {
    		Integer frequency = map.get(key);
    		if(buckets[frequency] == null){
    			buckets[frequency] = new ArrayList<>();
    		}
    		buckets[frequency].add(key);
    	}
    	
    	int[] ans = new int[k];
    	for(int i = nums.length; i>=0 && k > 0; i--) {
    		List<Integer> bucket = buckets[i];
    		if(bucket != null) {
    			int size = bucket.size();
    			for(int j = 0; j < size && k > 0; j++) {
    				ans[--k] = bucket.get(j);
    			}
    		}
    	}
    	return ans;
    }
}