class Solution {
    static int order = 0;
    static String[] alphabet = new String[]{"A","E","I","O","U"};
    static boolean found = false;
    public int solution(String word) {

        dfs(word, new StringBuilder());
        return order;
    }
    
    public void dfs(String word, StringBuilder sb) {
        // 종료 조건 -> 정답을 찾았을 때
        if (sb.toString().equals(word)) {
            found = true;
            return;
        }
        
        // 종료 조건 -> 단어 길이가 5일 때
        if (sb.length() == 5) return;
        
        for (int i = 0; i < alphabet.length; i++) {
            if (found) return;
            order++;
            sb.append(alphabet[i]);
            dfs(word, sb);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    } 
}