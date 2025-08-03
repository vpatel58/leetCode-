class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                len++;
                max = Math.max(max, len);
            } else {
                len = 1;
            }
        }
        return max;
    }
}
