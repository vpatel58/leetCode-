class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int x : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(x);
            for (int y : prev) {
                curr.add(x | y);
            }
            result.addAll(curr);
            prev = curr;
        }
        return result.size();
    }
}
