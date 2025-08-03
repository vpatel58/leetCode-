// User function Template for Java

class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            list[i].add(arr[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int len = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    list[i] = new ArrayList<>(list[j]);
                    list[i].add(arr[i]);
                    len = Math.max(len, dp[i]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == len) {
                ans = list[i];
                break;
            }
        }
        return ans;
    }
}
