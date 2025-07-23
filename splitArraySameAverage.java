import java.util.*;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;

        Arrays.sort(nums);
        Set<Integer>[] dp = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = new HashSet<>();
        dp[0].add(0);

        for (int num : nums) {
            for (int i = n - 1; i >= 0; i--) {
                for (int s : dp[i]) {
                    dp[i + 1].add(s + num);
                }
            }
        }

        for (int len = 1; len < n; len++) {
            if ((sum * len) % n != 0) continue;
            int target = (sum * len) / n;
            if (dp[len].contains(target)) return true;
        }

        return false;
    }
}
