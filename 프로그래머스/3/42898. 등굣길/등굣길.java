class Solution {
    static final int divNum = 1000000007;
    static final int water = -1;
    public int solution(int m, int n, int[][] puddles) {
        // 최단 경로의 개수
        // 위에서 내려오는 경로의 수와 왼쪽에서 온 경로의 수를 더한다?
        // 물에 잠긴 지역은 미리 표시해둔다
        
        
        int[][] dp = new int[n][m];
        
        // 물에 잠긴 지역 미리 표시
        for (int i = 0; i < puddles.length; i++){
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = water;
        }
        
        dp[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == water) continue;
                
                if (i - 1 >= 0 && dp[i - 1][j] != water) {
                    dp[i][j] += dp[i - 1][j];
                }
                
                if (j - 1 >= 0 && dp[i][j - 1] != water) {
                    dp[i][j] += dp[i][j - 1];
                }
                dp[i][j] %= divNum;
            }
        }
        
        return dp[n - 1][m - 1] % divNum;
    }
}