class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String N = String.valueOf(n);
        int digit = N.length();
        int dSize = digits.length;
        int total = 0;
        for (int i = 1; i < digit; i++) {
            total += Math.pow(dSize, i);
        }
        for (int i = 0; i < digit; i++) {
            boolean same = false;
            for (String s : digits) {
                if (s.charAtx(0) < N.charAt(i)) {
                    total += Math.pow(dSize, digit - i - 1);
                } else if (s.charAt(0) == N.charAt(i)) {
                    same = true;
                    break;
                }
            }
            if (!same) return total;
        }
        return total + 1;
    }
}
