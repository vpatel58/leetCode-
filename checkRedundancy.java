class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                boolean hasOperator = false;
                
                if (!st.isEmpty() && st.peek() == '(') return 1;
                
                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }
                if (!st.isEmpty()) st.pop();
                if (!hasOperator) return 1;
                
            } else {
                st.push(c);
            }
        }
        return 0;
    }
}
