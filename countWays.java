// User function Template for Java
class Solution {
    static int[][][] dp;
    static int countWays(String s) {
        // code here
        dp = new int[s.length()][s.length()][2];
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return helper(s, 0, s.length() - 1, 1);
    }
    
    public static int helper(String s, int i, int j, int isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == 1) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int ways = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lt = helper(s, i, k - 1, 1);
            int lf = helper(s, i, k - 1, 0);
            int rt = helper(s, k + 1, j, 1);
            int rf = helper(s, k + 1, j, 0);
            
            if (s.charAt(k) == '&') {
                if (isTrue == 1) {
                    ways = ways + (lt * rt);
                } else {
                    ways = ways + (lt * rf) + (lf * rt) + (lf * rf);
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue == 1) {
                    ways = ways + (lt * rt) + (lf * rt) + (lt * rf);
                } else {
                    ways = ways + (lf * rf);
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue == 1) {
                    ways = ways + (lf * rt) + (lt * rf);
                } else {
                    ways = ways + (lt * rt) + (lf * rf);
                }
            }
        }
        return dp[i][j][isTrue] = ways;
    }
}
