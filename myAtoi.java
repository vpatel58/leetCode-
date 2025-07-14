class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        long num = 0;
        int j = 0;
        boolean isNegative = false;
        if (s.charAt(0) == '+') j++;
        else if (s.charAt(0) == '-') {
            j++;
            isNegative = true;
        }
        for (int i = j; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) break;
            
            num = num * 10 + c - '0';

            if (isNegative && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (!isNegative && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }

        return isNegative ? (int) -num : (int) num;
    }
}
