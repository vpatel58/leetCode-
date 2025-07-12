class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = 0;
        while (k > 0 && idx < nums.length && nums[idx] < 0 ) {
            nums[idx] = -nums[idx];
            idx++;
            k--;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (k % 2 == 0) return sum;
        nums[0] = -nums[0];
        int xsum = 0;
        for (int i = 0; i < nums.length; i++) {
            xsum += nums[i];
        }
        return xsum; 
    }
}
