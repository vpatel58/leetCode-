class Solution {
    int longest;
    HashMap<String, Integer> map;
    StringBuilder sb;
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals(text2)) return text1.length();
        int m = text1.length();
        int n = text2.length();
        longest = Integer.MIN_VALUE;
        map = new HashMap<>();
        sb = new StringBuilder();
        if (m < n) return longestCommonSubsequence(text2, text1);
        int total = 1 << n;
        for (int mask = 0; mask < total; mask++) {
            StringBuilder sbl = new StringBuilder();
            for (int i = 0; i < n; i++) {
                // If i-th bit is set, include str.charAt(i)
                if ((mask & (1 << i)) != 0) {
                    sbl.append(text2.charAt(i));
                }
            }
            map.put(sbl.toString(), sbl.toString().length());
        }
        helper(text1, text2, 0);
        return longest;
    }

    public void helper(String s, String t, int idx) {
        //base 
        if (map.containsKey(sb.toString())) {
            longest = Math.max(longest, map.get(sb.toString()));
        } 
        if (idx == s.length()) return;
        if (sb.length() > t.length()) return;
        //logic
        helper(s, t, idx + 1);
        sb.append(s.charAt(idx));
        helper(s, t, idx + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
