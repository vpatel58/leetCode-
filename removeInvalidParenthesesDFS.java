class Solution {
    Set<String> set;
    List<String> result;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        set = new HashSet<>();
        result = new ArrayList<>();
        dfs(s);
        return result;
    }

    public void dfs(String s) {
        //base
        if (set.contains(s) || s.length() < max) return;
        //logic
        set.add(s);
        if (isValid(s)) {
            if (s.length() > max){
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            } else if (s.length() == max) {
                result.add(s);
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetter(c)) continue;
                String sub = s.substring(0, i) + s.substring(i + 1);
                dfs(sub);
            }
        }
    }

    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            else if (c == ')')  {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}
