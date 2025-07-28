class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) count++;
            else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) count++;
            else {
                int r = i + 1;
                while (r < n && nums[r] == nums[r - 1]) r++;
                if (r < n && nums[i] > nums[i - 1] && nums[i] > nums[r]) count++;
                else if (r < n && nums[i] < nums[i - 1] && nums[i] < nums[r]) count++;
            }
        }
        return count;
    }
}
