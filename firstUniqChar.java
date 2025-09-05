class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                q.add(ch);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        char ch = '1';
        while (!q.isEmpty()) {
            char c = q.poll();
            if (map.get(c) == 1) {
                ch = c;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) return i;
        }
        return -1;
    }
}
