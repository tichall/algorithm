import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);

            // 연쇄 pop
            while (!st.isEmpty() && k > 0 && st.peek() < cur) {
                st.pop();
                k--;
            }
            st.push(cur);
        }

        // 끝까지 봤는데 k가 남으면 뒤에서 자르기
        int size = st.size() - k;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(st.get(i));
        }
        return sb.toString();
    }
}
