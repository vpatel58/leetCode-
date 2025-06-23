class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, new ArrayList<>(), visited);
        return result;
    }

    private void helper(int[] nums, List<Integer> used, boolean[] visited) {
        if (nums.length == used.size()) {
            List<Integer> list = new ArrayList<>(used);
            result.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (!visited[i] && i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) ) continue;
            else {
                visited[i] = true;
                used.add(nums[i]);
                helper(nums, used, visited);
                used.removeLast();
                visited[i] = false;
            }
        }
    }
}
