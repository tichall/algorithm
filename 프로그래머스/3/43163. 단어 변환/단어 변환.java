import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // begin 단어에서 target 단어로 변환하는 가장 짧은 단계를 반환
        // 1. 한 번에 알파벳 하나
        // 2. words에 있는 단어로만 변환 가능
        // 변환이 불가능하다면 0을 반환 -> words에 target 값이 없다면 0 반환
        int difIdx = 0;
        String[] s = begin.split("");
        List<String> list = new ArrayList<>();
        
        Queue<String> que = new LinkedList<>();
        Queue<Integer> depthQue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        que.add(begin);
        depthQue.add(0);
        
        while (!que.isEmpty()) {
            String cur = que.poll();
            int depth = depthQue.poll();
            
            if (cur.equals(target)) return depth;
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (oneDiff(cur, words[i])) {
                    que.add(words[i]);
                    depthQue.add(depth + 1);
                    visited[i] = true;
                }
            }
            
        }
        return 0;
    }
    
    private boolean oneDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        
        return diff == 1;
    }
}