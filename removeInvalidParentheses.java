class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (isValid(curr)) {
                    found = true;
                    result.add(curr);
                } else if (!found){
                    for (int j = 0; j < curr.length(); j++) {
                        if (Character.isLetter(curr.charAt(j))) continue;
                        String sub = curr.substring(0, j) + curr.substring(j + 1);
                        if (!set.contains(sub)) {
                            set.add(sub);
                            q.add(sub);
                        }
                    }
                }
            }
        }
        return result;
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
