import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // participant : 선수 이름 배열
        // completion : 완주 선수 이름 배열
        // 완주 못한 선수 이름 리턴하기 -> 완주하지 못한 선수는 1명
        // participant에서 completion에 존재하지 않는 이름을 반환해야 함
        
        HashMap<String, Integer> map = new HashMap<>();
        String result = "";
        
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        for (String player : completion) {
            map.replace(player, map.get(player) - 1);
        }
        
        for (Map.Entry<String, Integer> elem : map.entrySet()) {
            if (elem.getValue() != 0) {
                result = elem.getKey();
            }
        }
        
        return result;
    }
}