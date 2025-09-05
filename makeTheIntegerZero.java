class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        long t = 0;
        while (true) {
            long val = (long) num1 - (t * (long) num2);
            if (val < 0) return -1;
            if (Long.bitCount(val) <= t && t <= val) {
                return (int) t;
            }
            t++;
        }
    }
}
