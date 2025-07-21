class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int len = 1;
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len++;
            } else {
                int index = binarySearch(dp, 0, len - 1, nums[i]);
                dp[index] = nums[i];
            }
        }
        return len;
    }
    public int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
