import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // n -> 입국 심사를 기다리는 사람 수
        // times의 크기 -> 심사관의 수
        // 모든 사람이 심사를 받는데 걸리는 최소 시간
        // 가능한 시간들은 연속적이지 않고 규칙이 있다. 있나..?
        // 그니까 이분탐색을 할 정답 후보들을 찾는게 지금 더 어려운 것 같은데..
        // 가능한 값 -> 나눠서 걍 순서대로 들어가는 것
        // times
        // 첫 번째 사람은
        // 일단 시간이 적게 걸리는 심사대로 가는 게 이득인데
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long mid = 0;
        
        while (left < right) {
            mid = left + (right - left) / 2;
            long people = 0;
            
            for (int time : times) {
                people += mid / time;
                if (people >= n) break;
            }
            
            if (people >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}