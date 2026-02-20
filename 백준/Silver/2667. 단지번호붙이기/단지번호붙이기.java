import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static boolean[][] visited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        // 덩어리 수를 세고, 각 덩어리에 포함되는 요소의 수를 오름차순 정렬
        // 덩어리 수는 미리 알 수 없기 때문에
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] houses = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(houses[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int result = dfs(i, j, map);
                if (result >= 1) list.add(result);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int houses : list) {
            System.out.println(houses);
        }
    }

    static int dfs(int r, int c, int[][] map) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        if (visited[r][c]) return 0;
        if (map[r][c] == 0) return 0;

        int cnt = 1;
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];

            if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length) continue;

            if (map[nextR][nextC] == 1) {
                cnt += dfs(nextR, nextC, map);
            }
        }

        return cnt;
    }
}
