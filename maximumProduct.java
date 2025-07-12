class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int maxP = Integer.MIN_VALUE;
        int product = 1;
        int idx = nums.length - 1;
        for (int i = 0; i < 3; i++) {
            product *= nums[idx--];
        }
        maxP = Math.max(maxP, product);
        product = 1;
        product = nums[0] * nums[1] * nums[nums.length - 1];
        maxP = Math.max(maxP, product);
        return maxP;
    }
}
