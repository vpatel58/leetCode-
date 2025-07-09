class Solution {
    public int maxSubArray(int[] nums) {
        int start = 0, end = 0, currStart = 0;
        int rsum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > rsum + nums[i]) {
                currStart = i;
                rsum = nums[i];
            } else {
                rsum += nums[i];
            }
            if (rsum > max) {
                start = currStart;
                end = i;
                max = rsum;
            }
        }
        return max;
    }
}
