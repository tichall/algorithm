import java.util.*;

class Solution {
    boolean solution(String s) {
        // 스택을 쓴다면
        // 닫는 괄호인 경우 스택에 담긴 최상위 요소가 여는 괄호인지 확인
        // 여는 괄호라면 pop, 아니라면 false 반환
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else stack.pop();
            }
        }

        return stack.isEmpty();
    }
}