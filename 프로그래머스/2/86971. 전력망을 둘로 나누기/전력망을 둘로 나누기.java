import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] wires) {
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