import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        // 단어가 중복되지 않게 몇번 등장하는지 최대 등장 횟수를 출력
        // 문서 길이는 최대 2500
        // 단어 길이는 최대 50

        // 첫 번째 시작 문자부터 찾으려는 단어와 일치하는지 확인한다.
        // 문자가 단어와 일치한다면 -> 다음 문자도 일치하는지 확인
        // 일치하지 않는다면 -> 다음 문자로 건너뛰어 처음부터 확인

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String doc = br.readLine();
        String word = br.readLine();
        int wordLen = word.length();

        int result = 0;

        for (int i = 0; i <= doc.length() - wordLen; i++) {
            int curResult = 0;
            int j = i;

            while (j <= doc.length() - wordLen) {
                String temp = doc.substring(j, j + wordLen);
                if (word.equals(temp)) {
                    curResult++;
                    j += wordLen;
                    continue;
                }
                j++;
            }
            result = Math.max(result, curResult);
        }
        System.out.println(result);
//        bw.write(result);
//        bw.flush();
//        bw.close();
    }
}