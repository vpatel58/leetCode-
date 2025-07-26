// User function Template for Java

class Solution {
    int[][] dp;
    public int LongestRepeatingSubsequence(String s) {
        // code here
        dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(s, s, 0, 0);
    }
    
    public int helper(String s, String t, int i, int j) {
        if (i == s.length() || j == s.length()) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == s.charAt(j) && i != j) {
            return 1 + helper(s, t, i + 1, j + 1);
        }
        
        return dp[i][j] = Math.max(helper(s, t, i + 1, j), helper(s, t, i, j + 1));
    }
}
