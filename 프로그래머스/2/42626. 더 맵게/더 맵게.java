import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 모든 음식의 스코빌 지수를 K 이상이 될 때까지
        // 섞어야 하는 최소 횟수
        // 스코빌 지수를 정렬한다.
        // 스코빌 지수가 K보다 작은 것들을 따로 저장한다.
        // 공식에 따라 음식을 섞는다. 섞은 후 K보다 커지면 자료 구조에서 뺀다.
        // K보다 작은 경우
        // 해당 자료 구조의 길이가 0이 될때까지 반복한 후 리턴한다.
        PriorityQueue<Integer> scov = new PriorityQueue<>();
        int count = 0;
        
        for(int s : scoville) {
            scov.add(s);
        }

        while(scov.peek() < K && scov.size() > 1) {
            int mixScov = scov.poll() + (scov.poll() * 2);
            scov.add(mixScov);
            count++;
        }
        
        if (scov.size() == 1 && scov.peek() < K) {
            return -1;
        }
        
        return count;
    }
}