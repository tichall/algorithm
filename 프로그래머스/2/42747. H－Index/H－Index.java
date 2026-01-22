import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 일단 정렬
        // 정렬 이후에 citations의 중간값?을 찾는다?
        // 해당 중간값과 
        int thesis = citations.length;
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < thesis; i++) {
            int citation = citations[i];
            int hCandidate = Math.min(citation, thesis - i);
            if (answer < hCandidate) answer = hCandidate;
        }
        return answer;
    }
}