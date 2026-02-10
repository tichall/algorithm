import java.util.*;

class Solution {
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        // 방문하는 공항의 경로를 배열에 담아 반환
        // 주어진 항공권을 모두 사용해라
        // 가능한 경로가 2개 이상이면 알파벳 순서가 앞서는 경로..
        // 알파벳 순서가 앞서는 경로부터 탐색할 수 있도록 한다.
        // visited 배열 사용할 때에도 공항 이름 String을 인덱스로 어떻게 매핑하지..?
        visited = new boolean[tickets.length];
        
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> path = new ArrayList<>();
        
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            if (!map.containsKey(start)) {
                map.put(start, new ArrayList<>());
            }
            List<Integer> list = map.get(start);
            list.add(i);
        }
        
        for (List<Integer> list : map.values()) {
            list.sort((a, b) -> tickets[a][1].compareTo(tickets[b][1]));
        }
        
        path.add("ICN");
        dfs("ICN", path, tickets, map);
        return path.toArray(new String[0]);
    }
     
    public boolean dfs(String start, 
                        List<String> path,
                        String[][] tickets,
                        Map<String, List<Integer>> map
    ) {
        if (path.size() == tickets.length + 1) return true;
        // 출발지에서 갈 수 있는 도착지를 순회
        for (Integer end : map.getOrDefault(start, Collections.emptyList())) {
            if (!visited[end]) {
                String nextAirport = tickets[end][1];
                
                visited[end] = true;
                path.add(nextAirport);
                if (dfs(nextAirport, path, tickets, map)) return true;
                visited[end] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}