import java.util.*;

public class Solution {
    public Integer[] solution(int []arr) {
        // 스택이나 큐를 쓰지 않고도 풀 수 있지 않을까?
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                continue;
            } 
            
            answer.add(arr[i]);
        }

        return answer.toArray(new Integer[answer.size()]);
    }
}