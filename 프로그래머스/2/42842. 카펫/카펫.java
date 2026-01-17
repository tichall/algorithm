class Solution {
    public int[] solution(int brown, int yellow) {
        // 노란색 격자의 모양이 확정되면 노란색 격자의 가로, 세로에 2 더한 게 답
        int[] answer = new int[2];
        
        if (yellow == 1) {
            return new int[]{3, 3};
        }
        
        for (int i = 1; i <= yellow / 2; i++) {
            if(yellow % i == 0) {
                int h = yellow / i;
                int tempBrown = i * 2 + h * 2 + 4;
                
                if(tempBrown == brown) {
                    answer[0] = h + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }
        return answer;
    }
}