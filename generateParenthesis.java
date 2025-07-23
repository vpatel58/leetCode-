class Solution {
    StringBuilder sb;
    List<String> result;
    public List<String> generateParenthesis(int n) {
        if (n == 1) return new ArrayList<>(List.of("()"));
        sb = new StringBuilder();
        result = new ArrayList<>();
        helper(n, 0);
        return result;
    }

    public void helper(int n, int idx) {
        //base
        if (idx == n * 2) {
            if(isValid(sb.toString())) {
                result.add(sb.toString());
                return;
            }
            return;
        }

        //logic
        sb.append("(");
        helper(n, idx + 1);
        if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        helper(n, idx + 1);
        if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
    }

    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}
