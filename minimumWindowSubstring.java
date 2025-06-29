class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int startIdx = -1;
        int ln = Integer.MAX_VALUE;
        int left = 0, right = 0, count = 0;

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (right < s.length()) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                if (map.get(r) > 0) count++;
                map.put(r, map.get(r) - 1);

            }
            //map.put(r, map.getOrDefault(r, 0) + 1);

            while (count == t.length()) {
                if (right - left + 1 < ln) {
                    ln = right - left + 1;
                    startIdx = left;
                }

                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) count--;
                }
                left++;
            }
            right++;
        }
        if (startIdx == -1) return "";
        return s.substring(startIdx, startIdx + ln);
    }
}
