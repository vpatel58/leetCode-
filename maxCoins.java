class Solution {
    int maxTotal;
    public int maxCoins(int[] nums) {
        maxTotal = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        helper(list, 0, 0);
        return maxTotal;
    }
    public void helper(List<Integer> nums, int idx, int total) {
        if (nums.size() == 0) {
            maxTotal = Math.max(total, maxTotal);
            return;
        }
        if (idx >= nums.size()) return;
        int prev = 1;
        if (idx - 1 >= 0) {
            prev = nums.get(idx - 1);
        }
        int next = 1;
        if (idx + 1 <= nums.size() - 1) {
            next = nums.get(idx + 1);
        }
        int temp = nums.get(idx);
        nums.remove(idx);
        helper(nums, 0 , total + (prev * temp * next));
        nums.add(idx, temp);
        helper(nums, idx + 1, total);
    }
}
