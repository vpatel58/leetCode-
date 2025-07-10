class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0) return new int[] {};
        Stack<Integer> st = new Stack<>();
        int curr = 0, prev = 0;
        int[] res = new int[n];
        for (String log : logs) {
            String[] arr = log.split(":");
            curr = Integer.parseInt(arr[2]);
            if (arr[1].equals("start")) {
                if (!st.isEmpty()) {
                    res[st.peek()] += curr - prev;
                }
                int id = Integer.parseInt(arr[0]);
                st.push(id);
                prev = curr;
            } else {
                res[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return res;
    }
}
