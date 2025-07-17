class Solution {
    
    HashMap<Integer, Character> map;
    int total;
    int[] dp;

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        map = new HashMap<>();
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char) ('A' + i - 1));
        }
        return helper(s, 0, "");
    }
    public int helper(String s, int idx, String sub) {

        if (!sub.equals("")) {
            if (sub.charAt(0) == '0') return 0;
            if (!map.containsKey(Integer.parseInt(sub))) return 0;
        }

        if (idx >= s.length()) {
            total++;
            return 1;
        }
        if (dp[idx] != -1) return dp[idx];

        int case1 = 0;
        if (s.charAt(idx) != '0') {
            case1 = helper(s, idx + 1, s.substring(idx, idx + 1));
        }

        int case2 = 0;
        if (idx + 1< s.length()) {
            case2 = helper(s, idx + 2, s.substring(idx, idx + 2));
        }

        dp[idx] = case1 + case2;
        return dp[idx];
    }
}
