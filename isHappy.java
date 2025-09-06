class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) return false;
            set.add(n);
            n = calculate(n);
        }   
        return true;
    }

    public int calculate(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += (digit * digit);
            num /= 10;
        }
        return sum;
    }
}
