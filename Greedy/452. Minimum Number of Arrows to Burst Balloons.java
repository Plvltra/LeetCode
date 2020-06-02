class Solution {
    
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int nonlap = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > end){
            	nonlap++;
            	end = points[i][1];
            }
        }
        return nonlap;
    }
}