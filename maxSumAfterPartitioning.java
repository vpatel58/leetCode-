class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, k, 0);
    }

    public int helper(int[] nums, int k, int i) {
        if (i == nums.length) return 0;
        if (dp[i] != -1) return dp[i];
        int max = Integer.MIN_VALUE, len = 0, totalMax = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(nums.length, i + k); j++) {
            len++;
            max = Math.max(max, nums[j]);
            int sum = (max * len) + helper(nums, k, j + 1);
            totalMax = Math.max(sum, totalMax);
        }
        return dp[i] = totalMax;
    }
}
