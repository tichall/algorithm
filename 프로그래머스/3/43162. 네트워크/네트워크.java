import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // 0번과 0번이 연결되어 있으면 computers[0][0]은 1
        // 즉, 0번 컴퓨터에 대한 연결 정보는 computers[0]
        // 끊기지 않고 연결된 네트워크가 몇개인지....
        // 방향 없는 그래프
        boolean[] visited = new boolean[n];
        int network = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터라면 새로운 네트워크 시작
            if (!visited[i]) {
                network++;
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {
                    int cur = stack.pop();

                    for (int j = 0; j < n; j++) {
                        if (computers[cur][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            stack.push(j);
                        }
                    }
                }
            }
        }

        return network;
    }
}
