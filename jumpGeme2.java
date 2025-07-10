class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int curr = nums[0];
        int next = curr;
        int jumps = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) return jumps++;
            next = Math.max(next, i + nums[i]);
            if (i == curr) {
                jumps++;
                curr = next;
            }
        }
        return jumps;
    }
}
