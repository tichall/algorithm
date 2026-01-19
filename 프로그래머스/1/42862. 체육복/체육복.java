import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 여벌 있는 학생이 도난당한 경우를 제외시켜야 함
        int len = lost.length;
        int answer= n - len;
        Set<Integer> clothes = new HashSet<Integer>();
        boolean[] visited = new boolean[len];
        
        for(int num : reserve) {
            clothes.add(num);
        }
        
        Arrays.sort(lost);
        for(int i = 0; i < len; i++) {
            if(clothes.contains(lost[i])) {
                answer++;
                visited[i] = true;
                clothes.remove(lost[i]);
            }
        }


        for(int i = len - 1; i >= 0; i--) {
            if (visited[i]) continue;
            
            if(clothes.contains(lost[i] + 1)) {
                clothes.remove(lost[i] + 1);
                answer++;
            } else if(clothes.contains(lost[i] - 1)) {
                clothes.remove(lost[i] - 1);
                answer++;
            }
        }


        return answer;
    }
}