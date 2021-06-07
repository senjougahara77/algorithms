class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[] ones = new int[l];
        int[] zeros = new int[l];
        for (int i = 0; i < l; ++i) {
            for (char c : strs[i].toCharArray()) {
                if (c == '1') ones[i]++;
                else zeros[i]++;
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < l; ++i) {
            int zero = zeros[i]; 
            int one = ones[i];
            for (int j = m; j >= zero; --j) {
                for (int k = n; k >= one; --k) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
