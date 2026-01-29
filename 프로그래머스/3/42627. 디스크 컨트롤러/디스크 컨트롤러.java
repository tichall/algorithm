import java.util.*;

class Solution {
    static final int jobNumIdx = 0;
    static final int reqTimeIdx = 1;
    static final int workTimeIdx = 2;
    
    public int solution(int[][] jobs) {
        // 대기 큐에서 우선순위가 높은 작업을 꺼내서 시킨다.
        // 1. 소요 시간이 짧은 것
        // 2. 요청 시각이 빠른 것
        // 3. 작업 번호가 작은 것
        // 작업은 하나씩 직렬로 이루어진다.
        // 모든 작업의 평균 반환 시간 정수 부분을 반환한다.
        int[] returnTimes = new int[jobs.length];
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<int[]> que = new PriorityQueue<>(
            Comparator.comparingInt((int[] job) -> job[workTimeIdx])
            .thenComparingInt(job -> job[reqTimeIdx])
            .thenComparingInt(job -> job[jobNumIdx])
        );
        
        que.offer(new int[]{0, jobs[0][0], jobs[0][1]});
        int jobIdx = 1;
        int currentTime = jobs[0][0];
        
        // 대기 큐에서 빠져나간 작업의 작업 시간이 지난 후
        // 현재 시간보다 이전에 요청이 들어온 작업을 모두 대기 큐에 넣는다.
        // poll 한다.
        // 작업 시간을 더해 반환 시간을 저장한다.
        // 이 반복문을 언제 멈춰야 할 지 모르겠음
            // 큐가 비어있는 조건으로는 안된다... -> 초기가 비어있는 상태인데
            // 하나 미리 넣는다면..?
            // job에 있는 모든 요소들이 큐에 들어갔는가를 조건으로 하는 것이 가장 명확한데..
                // 이것도 사실 명확하지 않다. 이미 모든 요소가 들어갔지만 큐에서 기다리고 있는 작업이 존재할 수 있다.
            // 근데 job의 요소가 시간 순서대로 정렬되어 있다는 것이 보장되지 않았음..
            // 아니면 정렬하고 빼는 것도 방법임
        
        while (!que.isEmpty() || jobIdx < jobs.length) {
            // 현재 시간보다 전에 들어온 요청을 대기 큐에 넣는다.
            // 만약 0초에 작업이 들어오지 않는다면..?
            // 현재 for문에서는 이미 대기 큐에 들어간 작업이 또 들어간다..
            for (int i = jobIdx; i < jobs.length; i++) {
                if (jobs[i][0] <= currentTime) {
                    int[] newJob = new int[] {i, jobs[i][0], jobs[i][1]};
                    que.offer(newJob);
                    jobIdx = i + 1;
                }
            }
            
            // 뺄 작업을 뺀다.
            if (!que.isEmpty()) {
                int[] curJob = que.poll();
                currentTime += curJob[workTimeIdx];
                returnTimes[curJob[jobNumIdx]] = currentTime - curJob[reqTimeIdx];
            } else {
                currentTime++;
            }
        }
        
        int sum = 0;
        for (int returnTime : returnTimes) {
            sum += returnTime;
        }
        
        return sum / returnTimes.length;
    }
}