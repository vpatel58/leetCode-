class Solution {
    int[][] dp;
    public int cutRod(int[] price) {
        // code here
        int cap = price.length;
        
        dp = new int[cap + 1][cap + 1];
        for (int i = 0; i < cap + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(price, 0, cap);
        
    }
    
    public int helper(int[] nums, int idx, int cap) {
        if (cap == 0 && idx == nums.length) {
            return 0;
        }
        if (idx >= nums.length) return Integer.MIN_VALUE; 
        if (dp[idx][cap] != -1) return dp[idx][cap];
        int case1 = helper(nums, idx + 1, cap);
        int case2 = 0;
        if (cap - (idx + 1) >= 0) {
            case2 = nums[idx] + helper(nums, idx, cap - (idx + 1));   
        }
        return dp[idx][cap] = Math.max(case1, case2);
    }
}
