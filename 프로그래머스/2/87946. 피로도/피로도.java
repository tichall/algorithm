import java.util.*;

class Solution {
    static int max = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        // 순서를 바꿔가면서 전부 탐색해야하는데
        // 어떤 로직으로 해야하고, 효율적인 로직은 무엇인지 떠오르지 않음
        
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        return max;
    }
    
    // 매개변수로 어떤 값들을 취해야 할지
    public void dfs(int k, int[][] dungeons, int cnt) {
        max = Math.max(max, cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            
            // i번 던전 실행 가능하다면
            if (k >= need) {
                visited[i] = true;
                dfs(k - cost, dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }
} 