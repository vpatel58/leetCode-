class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < 2 * n; i++) {
            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int idx = s.pop();
                ans[idx] = nums[i % n];
            }   
            if (i < n) {
                s.push(i);
            }   
        }
        while (!s.isEmpty()) {
            int i = s.pop();
            ans[i] = -1;
        }
        return ans;

    }
}
