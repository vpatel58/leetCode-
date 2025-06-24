class Solution {
    int mainHead = -1;
    public int lastRemaining(int n) {
        
        return helper(n, 1, 1, true);
    }

    private int helper(int n, int head, int step, boolean left) {
        if (n == 1) {
            return head;
        }
        if (left || n % 2 != 0) {
            return helper(n / 2, head + step, step * 2, !left);
        } else {
            return helper(n / 2, head, step * 2, !left);
        }
    }
}
