// User function Template for Java

class Solution {
    static int[][] dp;
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        dp = new int[val.length + 1][capacity + 1];
        for (int i = 0; i < val.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(val, wt, 0, capacity);
    }
    
    public static int helper(int[] val, int[] wt, int idx, int cap) {
        if (idx == val.length || cap <= 0) return 0;
        
        if (dp[idx][cap] != -1) return dp[idx][cap];
        int case1 = helper(val, wt, idx + 1, cap);
        int case2 = 0;
        if (wt[idx] <= cap) {
            case2 = val[idx] + helper(val, wt, idx, cap - wt[idx]);
        }
        return dp[idx][cap] = Math.max(case1, case2);
    }
}
