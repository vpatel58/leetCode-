class Solution {
    // Function to calculate the number of subsets with a given sum
    static int[][] dp;
    public int perfectSum(int[] nums, int target) {
        // code here
        
        dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, target, 0);
    }
    
    public int helper(int[] nums, int target, int idx) {
        if (idx == nums.length && target == 0) {
            return 1;
        }
        if (target < 0 || idx == nums.length) return 0;
        if (dp[idx][target] != -1) return dp[idx][target];
        int case1 = helper(nums, target, idx + 1);
        int case2 = helper(nums, target - nums[idx], idx + 1);
        return dp[idx][target] = case1 + case2;
    }
}
