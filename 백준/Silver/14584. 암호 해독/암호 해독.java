import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 사전에 나오는 단어가 암호문에 하나 이상 나와야 함
        // 25번만 반복하면 정답이 나올듯?
        // 한 칸씩 옮겨서 암호문을 치환해본 뒤, 사전 속 단어가 존재하는지 확인한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] code = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());

        // 사전 세팅
        String[] dic = new String[N];
        for (int i = 0; i < N; i++) {
            dic[i] = br.readLine();
        }

        boolean isFound = false;

        for (int i = 0; i < 26; i++) {
            if (isFound) break;
            StringBuilder sb = new StringBuilder();
            for (char c : code) {
                char cr = (char) ((c + i - 97) % 26 + 97);
                sb.append(cr);
            }

            String result = sb.toString();

            for (String word : dic) {
                if (result.contains(word)) {
                    isFound = true;
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}