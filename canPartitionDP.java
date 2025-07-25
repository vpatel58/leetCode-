class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int target = totalSum / 2;
        if (totalSum % 2 != 0) return false;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= target; s++) {
                //not take
                boolean case1 = dp[i - 1][s];
                //take
                boolean case2 = false;
                if (s >= nums[i]) {
                    case2 = dp[i - 1][s - nums[i]];
                }
                dp[i][s] = case1 || case2;
            }
        }

        return dp[n - 1][target];
    }
}
