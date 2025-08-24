class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int len = 0;
        int ones = 0;
        // for (int i = 0; i < n; i++) {
        //     int zeros = 0;
        //     for (int j = i; j < n; j++) {
        //         if (nums[j] == 0 && zeros == 0) {
        //             zeros++;
        //             len = Math.max(j - i + 1, len);
        //         } else if (nums[j] == 1) {
        //             ones++;
        //             len = Math.max(j - i + 1, len);
        //         } else {
        //             break;
        //         }
        //     }
        // }
        int left = 0;
        int right = 0;
        int zeros = 0;
        while (right < n) {
            if (nums[right] == 0 && zeros == 0) {
                zeros++;
                len = Math.max(right - left + 1, len);
                right++;
            } else if (nums[right] == 1) {
                ones++;
                len = Math.max(right - left + 1, len);
                right++;
            } else {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
        }
        if (ones == 0) return 0;
        return len - 1;
    }
}
