class Solution {
    public int solution(int[][] sizes) {        
        int firstMax = 0;
        int secondMax = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int first = 0;
            int second = 0;
            
            if (sizes[i][0] > sizes[i][1]) {
                first = sizes[i][0];
                second = sizes[i][1];
            } else {
                first = sizes[i][1];
                second = sizes[i][0];
            }
            
            if(first > firstMax) firstMax = first;
            if(second > secondMax) secondMax = second;
        }
        
        return firstMax * secondMax;
    }
}