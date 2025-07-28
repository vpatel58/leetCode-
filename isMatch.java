class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (p.charAt(i - 1) == '*') {
                    if (j > 0) dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    else dp[i][j] = dp[i - 1][j];
                } else {
                    if (j > 0) {
                        if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}
