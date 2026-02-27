import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase;

        // s 문자열에 한 글자씩 접근한다. -> t 문자열에서 해당 글자를 가장 앞에서부터 찾는다. 그리고 자른다.
        while((testCase = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(testCase);
            String s = st.nextToken();
            String t = st.nextToken();
            boolean isSuccess = true;
            char[] strArr = s.toCharArray();

            for (char c : strArr) {
                if (t.isEmpty())  {
                    isSuccess = false;
                    break;
                }
                int i = t.indexOf(c);

                // 존재하지 않으면
                if (i == -1) {
                    isSuccess = false;
                    break;
                }

                t = t.substring(i + 1);
            }

            if (isSuccess) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
