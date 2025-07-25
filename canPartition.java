class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int target = totalSum / 2;
        if (totalSum % 2 != 0) return false;
        dp = new Boolean[nums.length + 1][target + 1];
        
        return helper(nums, 0, 0, target);
    }

    public boolean helper(int[] nums, int idx, int sum, int target) {
        if (sum == target) {
            return true;
        }
        if (idx == nums.length || sum > target) {
            return false;
        }
        if (dp[idx][sum] != null) return dp[idx][sum];

        boolean case1 = helper(nums, idx + 1, sum, target);
        boolean case2 = helper(nums, idx + 1, sum + nums[idx], target);

        return dp[idx][sum] = case1 || case2;
    }
}
