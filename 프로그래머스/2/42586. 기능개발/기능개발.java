import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 100 - 작업 진도 = 남은 진도
        // 남은 양을 해결하는데 걸리는 일수 
        // => 남은 진도 % 속도 == 0 ? 남은 진도 / 속도 : 남은 진도 / 속도 + 1
        // 각 작업마다 걸리는 일수를 모두 구한다.
        // 작업이 끝난 날 -> 해당 일수보다 적거나 같은 이후 작업이 전부 배포된다.
        Deque<Integer> days = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (remain + speeds[i] - 1) / speeds[i];
            days.add(day);
        }
        
        while (!days.isEmpty()) {
            int functions = 1; // 첫 번째 작업은 이미 꺼낼 것이므로 1로 시작
            int currentDay = days.pop(); // 기준이 되는 배포일

            // 큐가 비어있지 않고, 다음 작업이 기준일(currentDay) 이내에 끝나는 동안 반복
            while (!days.isEmpty() && days.peekFirst() <= currentDay) {
                days.pop();
                functions++;
            }

            answer.add(functions);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}