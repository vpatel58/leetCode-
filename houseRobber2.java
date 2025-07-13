class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int skip = 0;
        int take = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        int case1 = Math.max(skip, take);
        skip = 0;
        take = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        int case2 = Math.max(skip, take);
        return Math.max(case1, case2);
    }
}
