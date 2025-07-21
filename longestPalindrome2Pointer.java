class Solution {
    int start, end, max;
    public String longestPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            //oddLength
            helper(s, i, i);
            if (i + 1 < n) {
                helper(s, i, i + 1);
            }
        }
        return s.substring(start, end + 1);
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;

        if (max < right - left + 1) {
            max = right - left + 1;
            start = left;
            end = right;
        } 
    }
}
