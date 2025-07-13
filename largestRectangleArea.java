class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) return heights[0];
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int area = 0;
        for (int i = 0; i <= n; i++) {
            int curr = i == n ? 0 : heights[i];
            while (!s.isEmpty() && curr < heights[s.peek()]) {
                int top = s.pop();
                int height = heights[top];
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                area = Math.max(height * width, area);
            }
            s.push(i);
        }
        return area;
    }
}
