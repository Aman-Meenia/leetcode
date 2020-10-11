class Solution {
    public int calculateMinimumHP(int[][] du) {
        int dp[][] = new int[du.length][du[0].length];
        int n = du.length;
        int m = du[0].length;
        dp[n-1][m-1] = du[n-1][m-1] < 0 ? (du[n-1][m-1] * -1 + 1) : 1;
        
        for (int i = n-1; i >= 0; i--) {
            for (int j=m-1;j>=0;j--) {
                if (i == n-1 && j == m-1) {
                    continue;
                }
                if (i == n-1) {
                    int h = dp[i][j+1] - du[i][j];
                    dp[i][j] = Math.max(h, 1);
                }
                else if (j == m-1) {
                    int h = dp[i+1][j] - du[i][j];
                    dp[i][j] = Math.max(h, 1);
                }
                else {
                    int h = Math.min(dp[i][j+1], dp[i+1][j]);
                    h = h - du[i][j];
                    dp[i][j] = Math.max(h, 1);
                }
            }
        }
        return dp[0][0];
    }
}
