class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        helper(nums, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, List<Integer> used) {

        //base
        if (nums.length == used.size()) {
            List<Integer> list = new ArrayList<>(used);
            result.add(list);
            return;
        }
        //logic
        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                helper(nums, used);
                used.removeLast();
            }
        }
    }
}
