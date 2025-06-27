class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 1 && target == 1) return 1;
        helper(nums, target, 0, 0);
        return count;
    }

    private void helper(int[] nums, int target, int start, int sum) {
        //base
        if (start == nums.length) {
            if (sum == target) count++;
            return;
        }
        helper(nums, target, start + 1, sum + nums[start]);
        helper(nums, target, start + 1, sum - nums[start]);
    }
}
