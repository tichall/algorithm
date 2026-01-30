import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        // 전선 중 하나를 끊어 2개로 분할
        // 이 2개의 전력망의 송전탑 개수 차이를 반환
        // 모든 전선을 끊어보고 노드 수를 세야 한다
        // 그래프 자료 구조를 실제로 만들어야 하는가?
        
        // 그래프를 만든다.
        // 모든 간선에 대해
        
        // 그래프 만들기
        int minAbs = n;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            int nodes = dfs(wire[0], wire, graph);
            minAbs = Math.min(minAbs, Math.abs(n - 2 * nodes));
        }
        return minAbs;
    }
    
    public int dfs(int node, int[] wire, List<Integer>[] graph) {
        int cutA = wire[0];
        int cutB = wire[1];
        
        int cnt = 1;
        visited[node] = true;
        
        for (int next : graph[node]) {
            if (visited[next]) continue;
            
            // 지금 끊은 간선인 경우
            if ((node == cutA && next == cutB) ||
                (node == cutB && next == cutA)) {
                continue;
            }
            
            cnt += dfs(next, wire, graph);
        }
        
        return cnt;
    }
}