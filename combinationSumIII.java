class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        if (k > n) return new ArrayList<>();
        helper(k, n, new ArrayList<>(), 1, 0);
        return result;
    }

    private void helper(int k, int n, List<Integer> list, int idx, int sum) {

        if (list.size() == k && sum == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (list.size() > k || sum > n) return;
        

        for (int i = idx; i <= 9; i++) {
            list.add(i);
            helper(k, n, list, i + 1, sum + i);
            list.removeLast();
        }
        
    }
}
