class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> list, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, list, i + 1);
            list.removeLast();
        }
    }
}
