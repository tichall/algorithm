import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // I 숫자 -> 삽입
        // D 1 -> 최댓값 삭제
        // D -1 -> 최솟값 삭제
        // 최댓값과 최솟값을 바로 탐색할 수 있는 우선순위 큐를 두 개 만든다..?
        // 너무 낭비?
        // 근데 값을 삭제시킬 때 특정 값을 바로 삭제시킬 수 있는 메서드가 
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        
        for (String oper : operations) {
            if (oper.startsWith("I")) {
                int num = Integer.parseInt(oper.substring(2));
                maxQue.add(num);
                minQue.add(num);
            } else if (oper.equals("D 1") && !maxQue.isEmpty()) {
                // 최댓값 삭제
                int removeNum = maxQue.poll();
                minQue.remove(removeNum);
            } else if (oper.equals("D -1") && !minQue.isEmpty()) {
                // 최솟값 삭제
                int removeNum = minQue.poll();
                maxQue.remove(removeNum);
            }
        }
       
        if (maxQue.isEmpty()) {
            return new int[]{0,0};
        }
        
        // 최댓값, 최솟값 리턴
        int[] arr = new int[2];
        
        arr[0] = maxQue.poll();
        arr[1] = minQue.poll();
        
        return arr;
    }
}