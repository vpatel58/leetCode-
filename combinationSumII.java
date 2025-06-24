class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, int target, int idx, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            list.add(nums[i]);
            helper(nums, target - nums[i], i + 1, list);
            list.removeLast();
        }
    }
}
