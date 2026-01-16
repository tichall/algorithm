class Solution {
    public int solution(int[][] sizes) {
        
        // 가장 작은 지갑을 찾아야 함
        // 가로 길이 최대를 찾는다.
        // 세로 길이 최대를 찾는다.
        // 가로, 세로 중 최대값 -> 가장 긴 길이로 확정
        // 나머지 한 변의 길이를 어떻게 확정지어야 하지?
        
        int firstMax = 0;
        int secondMax = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int first = 0;
            int second = 0;
            for (int j = 0; j < sizes[0].length; j++) {
                if (sizes[i][j] > first) {
                    second = first;
                    first = sizes[i][j];
                } else {
                    second = sizes[i][j];
                }
            }
            if(first > firstMax) firstMax = first;
            if(second > secondMax) secondMax = second;
        }
        
        return firstMax * secondMax;
    }
}