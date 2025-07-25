class Solution {
    static Boolean[][] dp;
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        dp = new Boolean[arr.length + 1][sum + 1];
        
        return helper(arr, sum, 0);
    }
    static boolean helper(int[] arr, int target, int idx) {
        //base
        if (target == 0) {
            return true;
        }
        if (idx == arr.length || target < 0) {
            return false;
        }
        if (dp[idx][target] != null) return dp[idx][target];
        boolean case1 = helper(arr, target, idx + 1);
        boolean case2 = helper(arr, target - arr[idx], idx + 1);
        
        return dp[idx][target] = case1 || case2;
    }
}
