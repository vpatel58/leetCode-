// User function Template for Java

class Solution {
    int[] dp;
    public long countFriendsPairings(int n) {
        // code here
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n);
    }
    
    public long helper(int n) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];
        long case1 = helper(n - 1);
        long case2 = (n - 1) * helper(n - 2);
        
        return dp[n] = case1 + case2;
    }
}
