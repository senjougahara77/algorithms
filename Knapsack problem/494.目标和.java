class Solution {
    int res;
    int n;
    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) return 0;
        int pos = (sum + target) / 2;
        int[]dp = new int[pos + 1];
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = pos; j >= nums[i]; --j) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[pos];
    }
}
