import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // location에 해당하는 프로세스를 기억하고 있어야 함
        // deque를 사용해 프로세스를 큐에 넣었다 뺐다 했을 때 프로세스의 위치로 원하는 프로세스를 찾을 수 없음..
        // 1. 우선순위와 원래 프로세스 번호를 함께 저장하는 방법?
        // 2. 실제 큐를 조작하지 않고 바로 구하는 방법? -> 너무 복잡한 것 같다
        // 같은 우선순위를 가지는 프로세스 간의 순서를 구하는 방법
        
        Deque<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            que.add(new int[]{priorities[i], i});
        }
        
        int count = 0;
        
        while (true) {
            int[] currentProcess = que.pop();
            int queSize = que.size();
            
            for (int[] process : que) {
                if (currentProcess[0] < process[0]) {
                    que.add(currentProcess);
                    break;
                } else continue;
            }
            
            // 현재 프로세스가 실행된 경우
            if (queSize == que.size()) {
                count++;
                if (currentProcess[1] == location) return count;
            }
        }
    }
}