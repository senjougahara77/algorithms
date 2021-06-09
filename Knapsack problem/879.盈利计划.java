class Solution {
    int mod = (int)1e9 + 7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = n; j >= group[i]; --j) {
                for (int k = minProfit; k >= 0; --k) {
                    dp[j][k] += dp[j - group[i]][Math.max(k - profit[i], 0)];
                    if (dp[j][k] > mod) {
                        dp[j][k] -= mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; ++i) {
            res += dp[i][minProfit];
            if (res > mod) {
                res -= mod;
            }
        }
        return res;
    }
}
