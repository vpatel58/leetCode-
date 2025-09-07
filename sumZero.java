class Solution {
    public int[] sumZero(int n) {
        int[] nums = new int[n];
        if (n % 2 == 0) {
            int j = 1;
            for (int i = n / 2; i < n; i++) {
                nums[i] = j++;
            }
            j = -1;
            for (int i = n / 2 - 1; i >= 0; i--) {
                nums[i] = j--;
            }
        } else {
            int j = 0;
            for (int i = n / 2; i < n; i++) {
                nums[i] = j++;
            }
            j = -1;
            for (int i = n / 2 - 1; i >= 0; i--) {
                nums[i] = j--;
            }
        }
        return nums;
    }
}
