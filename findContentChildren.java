class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0;
        int l = 0;
        int r = 0;
        while ( l < g.length && r < s.length) {
            if (g[l] <= s[r]) {
                content++;
                l++;
                r++;
            } else {
                r++;
            }
        }
        return content;
    }
}
