class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            int b = n - i;
            boolean flag = false;
            while (b > 0) {
                int digit = b % 10;
                if (digit == 0) {
                    flag = true;
                    break;
                }
                b = b / 10;
            }
            if (flag) continue;
            
            int a = i;
            flag = false;
            while (a > 0) {
                int digit = a % 10;
                if (digit == 0) {
                    flag = true;
                    break;
                }
                a = a / 10;
            }
            if (flag) continue;
            return new int[] {n - i, i};
        }
        return new int[] {};
    }
}
