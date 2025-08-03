class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev = new int [n];
        int len = 1;
        int lastIdx = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j] == 0) && dp[i] < dp[j] + 1 ) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > len) {
                len = dp[i];
                lastIdx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (lastIdx != -1) {
            list.add(nums[lastIdx]);
            lastIdx = prev[lastIdx];
        }
        Collections.reverse(list);
        return list;
    }
}
