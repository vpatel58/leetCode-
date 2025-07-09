class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, start = 0, end = 1;
        while (end < prices.length) {
            if (start == end) {
                end++;
                continue;
            }
            int sum = prices[end] - prices[start];
            if (sum < 0) {
                start++;
            } else {
                profit = Math.max(profit, sum);
                end++;
            }
        }
        return profit;
    }
}
