class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> s = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == '(') continue;
            if (ch == 't' || ch == 'f' || ch == '!' || ch == '&' || ch == '|') s.push(ch);
            else if (ch == ')') {
                boolean hasT = false;
                boolean hasF = false;
                while (s.peek() != '&' && s.peek() != '|' && s.peek() != '!') {
                    char top = s.pop();
                    if (top == 't') hasT = true;
                    if (top == 'f') hasF = true;
                }

                char topChar = s.pop();
                if (topChar == '|') {
                    if (hasT) s.push('t') ;
                    else s.push('f');
                } else if (topChar == '&') {
                    if (hasF) s.push('f') ;
                    else s.push('t');
                } else {
                    if (hasT) s.push('f');
                    else s.push('t');
                }
            } 
        }    
        return s.peek() == 't';
    }
}
