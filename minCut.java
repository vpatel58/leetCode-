class Solution {
    int[][] dp;
    public int minCut(String s) {
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(s, 0, s.length() - 1);
    }

    public int helper(String s, int i, int j) {
        if (i >= j) return 0;
        if (isPalindrome(s, i, j) )return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            if (isPalindrome(s, i, k)) {
                int cuts = 1 + helper(s, k + 1, j);
                mini = Math.min(mini, cuts);
            }
        }
        return dp[i][j] = mini;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}
