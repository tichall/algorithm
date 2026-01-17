import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // 일단 자른 배열 구하기
        // 그리고 정렬하기
        int[] result = new int[commands.length];
        
        for (int x = 0; x < commands.length; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            
            List<Integer> list = new ArrayList<>();
            
            for (int y = i - 1; y < j; y++) {
                list.add(array[y]);
            }
            
            list.sort(Comparator.naturalOrder());
            result[x] = list.get(k - 1);
        }
        return result;
    }
}