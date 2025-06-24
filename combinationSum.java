class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result= new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int target, int idx, List<Integer> list) {
        //base
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (idx == nums.length || target < 0) return;
        //logic
        helper(nums, target, idx + 1, list);
        list.add(nums[idx]);
        helper(nums, target - nums[idx], idx, list);
        list.removeLast();
    } 
}
