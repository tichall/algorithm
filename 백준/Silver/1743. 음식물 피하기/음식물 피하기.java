import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        // 음식물이 떨어진 좌표가 주어짐
        // 가장 큰 음식물의 크기를 출력할 것 -> 좌표 상에서 제일 큰 덩어리 찾기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> foods = new ArrayList<>();
        boolean[][] hall = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        // 음식물 위치 표시
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            foods.add(new int[]{r, c});
            hall[r][c] = true;
        }

        for (int[] food : foods) {
            int r = food[0];
            int c = food[1];

            if (visited[r][c]) continue;
            max = Math.max(max, dfs(food[0], food[1], hall));
        }
        System.out.println(max);
    }

    public static int dfs(int r, int c, boolean[][] hall) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int cnt = 1;
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (nextR < 1 || nextC < 1 || nextR >= hall.length || nextC >= hall[0].length) continue;
            if (hall[nextR][nextC] && !visited[nextR][nextC]) {
                cnt += dfs(nextR, nextC, hall);
            }
        }
        return cnt;
    }
}
