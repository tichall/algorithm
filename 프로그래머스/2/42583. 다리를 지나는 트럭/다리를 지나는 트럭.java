import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리를 건너고 있는 트럭을 관리할 배열? 큐 필요
        // 한 대를 다리 위에 올린다.
        // bridge_length를 넘지 않았는지 검사한다. -> 넘었다면 초를 증가시킨다.
        // 그 다음 트럭의 무게를 검사한다. -> 올릴 수 없다면 초를 증가시킨다?

        // 다리 위에 있는 트럭을 관리할 큐
        Queue<int[]> que = new LinkedList<>();
        
        int second = 0; // 현재 초수
        int truckPassBridge = 0; // 다리를 건넌 트럭 수
        int weightOnBridge = 0; // 다리 위의 무게
        int truckIndex = 0; // 첫 번째 대기 트럭의 인덱스값
        
        // 트럭이 다 건너기 전까지 반복
        while (truckPassBridge < truck_weights.length) {
            second++;
            
            // 다리를 다 건넌 트럭이 있는지 확인
            if (!que.isEmpty() && (second - que.peek()[1]) == bridge_length) {
                int[] firstTruck = que.poll();
                weightOnBridge -= firstTruck[0];
                truckPassBridge++;
            }
            
            // 트럭을 더 올릴 수 있는 상태인지 확인
            if (truckIndex < truck_weights.length && que.size() < bridge_length && weightOnBridge < weight) {
                // 다음 트럭을 올릴 수 있는지 확인
                if (truck_weights[truckIndex] <= (weight - weightOnBridge)) {
                    que.add(new int[]{truck_weights[truckIndex], second});
                    weightOnBridge += truck_weights[truckIndex];
                    truckIndex++;
                }
            }   
        }
         
        return second;
    }
}