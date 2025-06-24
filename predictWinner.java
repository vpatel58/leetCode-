class Solution {
    public boolean predictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1, 0, 0, true);
    }

    private boolean helper(int[] nums, int start, int end, int p1Score, int p2Score, boolean p1Turn) {
        //base
        if (start > end) {
            return p1Score >= p2Score;
        }
        //logic
        if (p1Turn) {
            return helper(nums, start + 1, end, p1Score + nums[start], p2Score, false) || helper(nums, start, end - 1, p1Score + nums[end], p2Score, false);
        } else {
            return helper(nums, start + 1, end, p1Score, p2Score + nums[start], true) && helper(nums, start, end - 1, p1Score, p2Score + nums[end], true);
        }
    }
}
