class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == x) return mid;
            else if (square > x) right = mid - 1;
            else left = mid + 1;
        }
        return left - 1;
    }
}
