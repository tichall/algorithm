import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        int n = N;
      
        for (int i = 1; i <= 8; i++) {
            if (n == number) return i;
            
            Set<Integer> set = new HashSet<>();
            set.add(n);
            dp[i] = set;
            n = n * 10 + N;
        }
        
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                Set<Integer> targetSet = dp[i];
                Set<Integer> set1 = dp[j];
                Set<Integer> set2 = dp[i - j];
                
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