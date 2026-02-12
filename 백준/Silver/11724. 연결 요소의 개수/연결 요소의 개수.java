import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        // 연결 요소의 개수 출력하기
        // n -> 정점의 개수 (n번까지 정점 존재)
        // m -> 간선의 개수
        // 간선을 통해 연결된 덩어리가 몇개인지 파악해 반환하는 문제
        // 끊기는 지점까지 끝까지 파고 들어야 하니까 dfs 쓰는 게 맞나
        // 한 덩어리가 아니라면 dfs가 모든 노드를 탐색하지 못하고 끊기게 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        int result = 0;

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 연결리스트는 만들 수 있음
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        // 모든 노드를 탐색할 수 있을 때까지 dfs를 반복한다.
        // 해당 for문에서 dfs가 호출된 만큼이 정답이다.
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, graph);
                result++;
            }
        }
        System.out.println(result);

    }

    public static void dfs(int curNode, List<Integer>[] graph) {
        for (int linkedNode : graph[curNode]) {
            if (!visited[linkedNode]) {
                visited[linkedNode] = true;
                dfs(linkedNode, graph);
            }
        }
    }
}