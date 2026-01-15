import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 1번 수포자 : 1~5까지 차례대로 찍기
        // 2번 수포자 : 21232425 이렇게 반복
        // 3번 수포자 : 3311224455 이렇게 반복
        // answers 배열을 순회하면서 정답 개수 세기
        // 최고점이 여러 명일 수 있기 때문에 모든 학생의 점수를 저장해두는 게 나을까?
        // 여러 명인 경우 단순한 int 변수 하나로 관리할 수 없다 
        
        int[][] students = new int[][] {
            {1, 2, 3, 4, 5}, 
            {2, 1, 2, 3, 2, 4, 2, 5}, 
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        List<Integer> result = new ArrayList<>();
        int max = 0;
        
        for (int i = 0; i < students.length; i++) {
            int correct = 0;
            
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == students[i][j % students[i].length]) {
                    correct++;
                }
            }
            
            if (correct > max) {
                max = correct;
                result.clear();
                result.add(i + 1);
            } else if (correct == max) {
                result.add(i + 1);
            } 
        }
        
        result.sort(Comparator.naturalOrder());
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}