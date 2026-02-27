import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터를 삭제할 때 우선순위가 가장 높거나 낮은 데이터 중 하나를 삭제한다.
        // 1. 데이터 삽입 연산
        // 2. 데이터 삭제 연산
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            PriorityQueue<int[]> minQ = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // 큰 거 뒤로 보내기
            PriorityQueue<int[]> maxQ = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0])); // 작은 거 뒤로 보내기

            int k = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[k];

            for (int i = 0, idx = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();

                if (op.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    minQ.add(new int[]{num, idx});
                    maxQ.add(new int[]{num, idx});
                    visited[idx] = true;
                    idx++;
                } else if (op.equals("D")) {
                    String op2 = st.nextToken();
                    if (op2.equals("-1")) {
                        // 최솟값 삭제
                        while (!minQ.isEmpty() && !visited[minQ.peek()[1]]) {
                            minQ.poll();
                        }
                        if (!minQ.isEmpty()) {
                            visited[minQ.poll()[1]] = false;
                        }
                    } else if (op2.equals("1")) {
                        // 최댓값 삭제
                        while (!maxQ.isEmpty() && !visited[maxQ.peek()[1]]) {
                            maxQ.poll();
                        }
                        if (!maxQ.isEmpty()) {
                            visited[maxQ.poll()[1]] = false;
                        }
                    }
                }
            }

            while (!minQ.isEmpty() && !visited[minQ.peek()[1]]) {
                minQ.poll();
            }
            while (!maxQ.isEmpty() && !visited[maxQ.peek()[1]]) {
                maxQ.poll();
            }

            if (minQ.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxQ.peek()[0] + " " + minQ.peek()[0]);
            }
        }
    }
}
