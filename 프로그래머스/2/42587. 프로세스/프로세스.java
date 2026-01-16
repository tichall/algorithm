import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. 우선순위를 내림차순으로 관리할 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 2. 프로세스의 {우선순위, 원래 인덱스}를 담을 큐
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(new int[]{priorities[i], i});
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // 현재 꺼낸 프로세스의 우선순위가 가장 높은 우선순위인지 확인
            if (current[0] == pq.peek()) {
                count++;
                pq.poll(); // 실행 완료되었으므로 우선순위 큐에서도 제거

                // 찾고자 하는 위치의 프로세스라면 리턴
                if (current[1] == location) {
                    return count;
                }
            } else {
                // 더 높은 우선순위가 있다면 다시 뒤로 보냄
                queue.add(current);
            }
        }
        return count;
    }
}