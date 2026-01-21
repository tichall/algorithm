import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 문자열 자체로 비교를 하자
        // 숫자 각각으로 값을 예측해가면서 규칙을 어떻게 정의해야 할지 고민하지 말고
        // 그냥 합쳤을 때 더 큰 값을 만들어내는지를 검증하자
        
        // 주어진 numbers 배열을 문자열 배열로 변환한다.
        // 규칙에 맞게 배열을 정렬한다.
        // 순서대로 문자열을 이어붙인다.
        StringBuilder sb = new StringBuilder();
        String[] str = new String[numbers.length];
        
        for(int i = 0; i < str.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        
        if (str[0].equals("0")) {
            return "0";
        }
        
        for (String numStr : str) {
            sb.append(numStr);
        }
        
        return sb.toString();
    }
}