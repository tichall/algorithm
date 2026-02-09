import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        // 전선 중 하나를 끊어 2개로 분할
        // 이 2개의 전력망의 송전탑 개수 차이를 반환 (가장 적은 값)
        // 모든 전선을 끊어보고 노드 수를 세야 한다
        // 그래프 자료 구조를 실제로 만들어야 하는가?
        
        // 하나를 끊는다. -> 송전탑 하나에서 시작된 전력망 하나를 끝까지 탐색한다.
        // 전체 n에서 빼면 송전탑 개수의 차이
        int minAbs = n;
        List<Integer>[] linked = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            linked[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];
            
            linked[x].add(y);
            linked[y].add(x);
        }
        
        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            
            int startNode = wire[0];
            visited[startNode] = true;
            visited[wire[1]] = true;
            
            minAbs = Math.min(minAbs, Math.abs(n - 2 * dfs(startNode, linked)));
        }
        
        return minAbs;
    }
    
    public int dfs(int startNode, List<Integer>[] linked) {
        int nodes = 1;
        
        for (int node : linked[startNode]) {
            if (!visited[node]) {
                visited[node] = true;
                nodes += dfs(node, linked);
            } 
        }
        
        return nodes;
    }
}