import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 추가
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        Queue<Integer> que = new LinkedList<>(); // 연결된 노드를 넣을 큐
        int[] dist = new int[n + 1]; // 거리를 나타내는 배열
        Arrays.fill(dist, -1); // 아직 확인하지 않은 거리는 -1로 초기화
        
        // 1번 노드
        que.add(1); 
        dist[1] = 1;
        int max = 0;
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            
            // 현재 노드와 연결된 노드 탐색
            for (int next : graph[cur]) {
                // 해당 노드와의 거리를 확인하지 않은 경우
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    que.add(next);
                }
                if (max < dist[next]) max = dist[next];
            }
        }
        
        int result = 0;
        
        for (int d : dist) {
            if (d == max) result++;
        }
        return result;
    }
}