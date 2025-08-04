
class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < dp1.length; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                max = Math.max(max, dp1[i] + dp2[i] - 1);
            }
        }
        return max;
    }
}
