import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        // 정확하게 순위를 매길 수 있는 선수의 수를 리턴하기
        // 경기 결과 -> 그래프
        List<Integer>[] win = new ArrayList[n + 1];
        List<Integer>[] lose = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        };
        
        // 그래프 만들기
        for (int[] r : results) {
            int a = r[0];
            int b = r[1];
            win[a].add(b);
            lose[b].add(a);
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int winCnt = bfs(i, win, n);
            int loseCnt = bfs(i, lose, n);
            
            if (winCnt + loseCnt == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public int bfs(int start, List<Integer>[] graph, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        visited[start] = true;
        q.offer(start);
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}