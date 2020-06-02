class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
    	if(intervals.length == 0){
    		return 0;
    	}
    
		Arrays.sort(intervals,Comparator.comparingInt(o->o[1]));
		int removeNum = 0;
		int endPos = intervals[0][1];
		for(int i = 1; i < intervals.length; i++) {
			if(endPos > intervals[i][0]) {
				removeNum++;
				endPos = Math.min(endPos, intervals[i][1]);
			}else{
				endPos = intervals[i][1];
			}
		}
		return removeNum;
    }
}