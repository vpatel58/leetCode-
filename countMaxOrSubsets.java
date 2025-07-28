class Solution {
    int maxOr;
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = max | nums[i];
        }
        maxOr = max;
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int or, int idx) {
        if (idx == nums.length && or == maxOr) {
            return 1;
        }
        if (idx == nums.length) return 0;
        int case1 = helper(nums, or, idx + 1);
        int case2 = helper(nums, or | nums[idx], idx + 1);
        return case1 + case2;
    }
}
