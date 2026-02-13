import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        // 이것도 덩어리 찾기네요
        //

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int result;

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            result = 0;

            boolean[][] land = new boolean[n][m];
            visited = new boolean[n][m];

            // 배추 채우기
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                land[y][x] = true;
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (land[y][x] && !visited[y][x]) {
                        bfs(x, y, land);
                        result++;
                    }
                }
            }
            bw.append(Integer.toString(result));
            bw.newLine();
        }
        bw.flush();
    }

    public static void bfs(int x, int y, boolean[][] land) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= land[0].length || nextY >= land.length) continue;
                if (land[nextY][nextX] && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
