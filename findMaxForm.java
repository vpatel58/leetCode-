
class Solution {
    int[][][] dp;
    HashMap<String, int[]> map;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        dp = new int[len + 1][m + 1][n + 1];
        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, -1);
        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int zero = 0;
            int one = 0;
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') zero++;
                else one++;
            }
            map.put(strs[i], new int[] {zero, one});
        }
        return helper(strs, m, n, 0, 0, 0);
    }
    public int helper(String[] str, int m, int n, int idx, int zeroes, int ones) {
        if (idx == str.length) {
            return 0;
        }
        if (zeroes > m || ones > n || idx == str.length) return 0;
        //logic
        if (dp[idx][zeroes][ones] != -1) return dp[idx][zeroes][ones];
        int case1 = helper(str, m, n, idx + 1, zeroes, ones);
        int case2 = 0;
        if (zeroes + map.get(str[idx])[0] <= m && ones + map.get(str[idx])[1] <= n) {
            case2 = 1 + helper(str, m, n, idx + 1, zeroes + map.get(str[idx])[0], ones + map.get(str[idx])[1]);  
        }
        return dp[idx][zeroes][ones] = Math.max(case1, case2);
    }
}
