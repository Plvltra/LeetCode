class Solution {  
	// LeetCode 406. 思路有两种
	// 1.(1)对于(h,k)首先取最高h为一组, 
	//	  按k插入,由于后续插入高度都不如h高,其角标k正确
	//   (2)接着依次插入相同h的组, 由于之前插入的高于该组,
	//   只需要插入在角标k处就能保证k的正确
	//	E.g.
	//	input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	//	subarray after step 1: [[7,0], [7,1]]
	//	subarray after step 2: [[7,0], [6,1], [7,1]]
	// 2.对于(h,k),(hmin, kmax)最没影响,不会影响任何其他的k,
	//   而其他的都会影响该人的k,所以只需要在其他人就位后在kindex插入他
	//   接着插入次没影响力的，以此类推
    public int[][] reconstructQueue(int[][] people) {
    	if (people == null || people.length == 0) {
            return new int[0][0];
        }
    	
        Arrays.sort(people, 
        		(a, b) -> a[0] != b[0]? b[0] - a[0] : a[1] - b[1]);
        
        List<int[]> queue = new ArrayList<>();
        for(int[] p : people) {
        	queue.add(p[1], p);
        }
        return queue.toArray(new int[people.length][2]);
    }
}