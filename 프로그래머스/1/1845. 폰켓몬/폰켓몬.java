import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 가져갈 수 있는 포켓몬 종류의 수
        // 만약 이 수가 N/2보다 같거나 작다면 그냥 종류의 수가 정답
        // 만약 종류 개수가 더 많다면..? -> n/2가 정답
        // [1, 2, 3, 4, 5, 6] -> 가져갈 수 있는 수는 3개
        
        HashSet<Integer> species = new HashSet<>();
        
        for (int num : nums) {
            species.add(num);
        }
        
        int count = nums.length / 2;
        int speciesNum = species.size();
        
        int answer = count > speciesNum ? speciesNum : count;
        return answer;
    }
}