import java.util.*;

class Solution {
    int[][] board;
    boolean[][] visited;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 초기 캐릭터의 위치에서 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리 리턴
        // 직사각형들이 만나는 꼭지점을 사전에 다 찾아놓는다..?
        // 아니면 뭔가 정렬을 해놓을 수 있나..?
        
        // 출발점이 어느 사각형에 있는지 어떻게 찾지?
        // 모든 사각형을 순회하면서 해당 꼭짓점의 x좌표가 사각형의 x 좌표 사이에 있는지 확인
        // 해당 꼭짓점의 y좌표가 사각형의 y좌표 사이에 있는지 확인?
        
        // 한 사각형을 따라서 가다가 겹치는 사각형을 만나면 타고 올라가야 함?
        // 일단 좌표 만들기
        board = new int[101][101];
        visited = new boolean[101][101];
        
        // 외곽을 1로 만들기
        for (int[] rec : rectangle) {
            int leftDownX = rec[0] * 2;
            int leftDownY = rec[1] * 2;
            int rightTopX = rec[2] * 2;
            int rightTopY = rec[3] * 2;
            
            for (int i = leftDownX; i <= rightTopX; i++) {
                for (int j = leftDownY; j <= rightTopY; j++ ) {
                    board[i][j] = 1;
                }
            }
        }
        
        // 내부 싹 지우기
        for (int[] rec : rectangle) {
            int innerLeftX = rec[0] * 2 + 1;
            int innerLeftY = rec[1] * 2 + 1;
            int innerRightX = rec[2] * 2 - 1;
            int innerRightY = rec[3] * 2 - 1;
            
            for (int i = innerLeftX; i <= innerRightX; i++) {
                for (int j = innerLeftY; j <= innerRightY; j++ ) {
                    board[i][j] = 0;
                }
            }
        }
        
        int result = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return result / 2;
    }
    
    public int bfs(int startX, int startY, int targetX, int targetY) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, 0}); // 3번째 값은 지금까지의 거리
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            
            // 아이템을 찾았을 때
            if (x == targetX && y == targetY) {
                return dist;
            }
            
            for (int dir = 0; dir < 4; dir++) {
                int cx = x + dx[dir];
                int cy = y + dy[dir];
                
                if (cx < 0 || cy < 0 || cx >= board.length || cy >= board[0].length) continue;
                if (board[cx][cy] == 1 && !visited[cx][cy]) {
                    visited[cx][cy] = true;
                    q.offer(new int[]{cx, cy, dist + 1});
                }
            }
        }
        return -1;
    }
}