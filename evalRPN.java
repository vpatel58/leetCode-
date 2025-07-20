class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            char c = s.charAt(0);
            if (s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                int first = st.pop();
                int second = st.pop();
                if (c == '+') {
                    st.push(first + second);
                } else if (c == '-') {
                    st.push(second - first);
                } else if (c == '*') {
                    st.push(first * second);
                } else {
                    st.push(second / first);
                }
            } else {
                int num = Integer.parseInt(s);
                st.push(num);
            }
        }
        return st.pop();
    }
}
