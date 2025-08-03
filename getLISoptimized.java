import java.util.*;

class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 1, lastIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (lastIndex != -1) {
            ans.add(arr[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        Collections.reverse(ans);
        return ans;
    }
}
