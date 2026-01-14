import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 문제가 무슨 소리인지 잘 이해가 안 간다..
        List<Integer> answer = new ArrayList<>();
        
        // for문 돌면서 비교하기
        for (int i = 0; i < prices.length; i++) {
            int answerLength = answer.size();
            
            for (int j = i + 1; j < prices.length; j++) {
                // 가격이 떨어진 시점
                if (prices[i] > prices[j]) {
                    answer.add(j - i);
                    break;
                }
            }
            
            if (answerLength == answer.size()) {
                answer.add(prices.length - i - 1);
            }
        }        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}