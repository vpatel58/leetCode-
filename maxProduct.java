class Solution {
    public int maxProduct(int[] nums) {
        int runningLeft = 1;
        int runningRight = 1;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            runningLeft *= nums[i];
            max = Math.max(runningLeft, max);
            if (runningLeft == 0) {
                runningLeft = 1;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            runningRight *= nums[i];
            max = Math.max(runningRight, max);
            if (runningRight == 0) {
                runningRight = 1;
            }
        }
        return max;
    }
}
