class Solution {
    static int order = 0;
    static String[] alphabet = new String[]{"A","E","I","O","U"};
    static boolean found = false;
    public int solution(String word) {
        // 글자 5개로 만들 수 있는 길이 5 이하의 모든 단어
        // 만들 수 있는 모든 단어를 사전 순서대로 탐색하고, 
        // 탐색하는 동안 사전 순서를 1씩 늘리며 카운트한다. 아니면 맵 같은 곳에 저장해두거나..
        // 글자는 한 단어 안에서 반복될 수 있다. -> "AAAAA"
        // 백트래킹 필요..?
        dfs(word, "");
        return order;
    }
    
    public void dfs(String word, String newWord) {
        // if (found == true) return;
        
        if (newWord.equals(word)) {
            found = true;
            return;
        }
        
        if (newWord.length() < 5) {
            for (int i = 0; i < alphabet.length; i++) {
                if (found == true) return;
                order++;
                dfs(word, newWord + alphabet[i]);
            }
        }
        
        // a -> aa-> aaa -> aaaa -> aaaaa
        // 재귀호출에서 사전 순서를 어떻게 반환할 것인가..
    } 
}