import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // DFS와 BFS

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 세팅
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());

            graph[point1].add(point2);
            graph[point2].add(point1);
        }

        for (int i = 0; i < N + 1; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }

        visited = new boolean[N + 1];
        dfs(V, graph);

        System.out.println();
        visited = new boolean[N + 1];
        bfs(V, que, graph);
    }

    public static void dfs(int node, List<Integer>[] graph) {
        // 깊이우선탐색
        System.out.print(node + " ");
        visited[node] = true;

        for (Integer linkedNode : graph[node]) {
            if(!visited[linkedNode]) {
                dfs(linkedNode, graph);
            }
        }
    }

    public static void bfs(int node, Queue<Integer> que, List<Integer>[] graph) {
        // 너비우선탐색
        que.add(node);
        visited[node] = true;

        while (!que.isEmpty()) {
            int curNode = que.poll();
            System.out.print(curNode + " ");

            for (Integer linkedNode : graph[curNode]) {
                if (!visited[linkedNode]) {
                    visited[linkedNode] = true;
                    que.add(linkedNode);
                }
            }
        }
    }
}
