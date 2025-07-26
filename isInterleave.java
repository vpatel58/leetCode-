class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (s3.length() != n + m) return false;
        dp = new Boolean[n + 1][m + 1];
        return helper(s1, s2, s3, 0, 0);
    }

    public boolean helper(String s1, String s2, String s3, int i, int j) {
        if (i + j == s3.length()) return true;

        if (dp[i][j] != null) return dp[i][j];
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            ans = helper(s1, s2, s3, i + 1, j);
        } 
        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            ans  = helper(s1, s2, s3, i, j + 1);
        }
        return dp[i][j] = ans;
    }
}
