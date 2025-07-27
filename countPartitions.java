
class Solution {
    int totalSum;
    int sum1;
    int[][] dp;
    int countPartitions(int[] arr, int d) {
        // code here    
        totalSum = 0;
        sum1 = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if ((d + totalSum) % 2 == 0) {
            sum1 = (d + totalSum) / 2;
        } else {
            return 0;
        }
        dp = new int[arr.length + 1][sum1 + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return helper(arr, 0, 0);
    }
    
    public int helper(int[] nums, int idx, int sum) {
        if (sum == sum1 && idx == nums.length) {
            return 1;
        }
        if (idx == nums.length || sum > sum1) {
            return 0;
        }
        if (dp[idx][sum ] != -1) return dp[idx][sum];
        int case1 = helper(nums, idx + 1, sum);
        int case2 = helper(nums, idx + 1, sum + nums[idx]);
        
        return dp[idx][sum] = case1 + case2;
    }
}
