import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 각 종류마다 하나만 선택 가능
        // 서로 다른 옷의 조합 수를 리턴
        // 의상의 종류당 개수를 알아야 함
        
        // 1. 해시를 쓴다면?
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int result = 1;

        for (Integer value : map.values()) {
            result *= (value + 1);
        }
        
        return result - 1;
    }
}