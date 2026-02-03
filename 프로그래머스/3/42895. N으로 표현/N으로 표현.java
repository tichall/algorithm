import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 숫자 N를 사용해 number를 만드는 방법 중
        // N을 가장 적게 사용한 횟수
        
        // 1개를 사용해서 number를 구할 수 있는지 확인
        // 이후 2개, 3개, ... 이렇게 늘려가면서?
        // number를 만드는 방법 자체를 
        // 어떻게 표현해서 확인할 수 있을지 모르겠는데?
        List<Set<Integer>> dp = new ArrayList<>(9);
        dp.add(new HashSet<>());
        
        // N을 반복한 숫자는 얼마까지 만들어야 할지?
        // 초기값 세팅
        for (int i = 1; i <= 8; i++) {
            int num = Integer.parseInt(Integer.toString(N).repeat(i));
            if (num == number) return i;
            Set<Integer> set = new HashSet<>();
            set.add(num);
            dp.add(i, set); 
        }
        
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                Set<Integer> targetSet = dp.get(i);
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);
                
                for (Integer num1 : set1) {
                    for (Integer num2 : set2) {
                        targetSet.add(num1 + num2);
                        targetSet.add(num1 - num2);
                        targetSet.add(num2 - num1);
                        targetSet.add(num1 * num2);
                        if (num2 != 0) targetSet.add(num1 / num2);
                        if (num1 != 0) targetSet.add(num2 / num1);
                    }
                }
                
                if (targetSet.contains(number)) return i;
            }
        }
        
        return -1;
    }
}