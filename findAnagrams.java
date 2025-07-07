class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p.length() > s.length()) return new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int match = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                int cnt = map.get(r);
                cnt--;
                if (cnt == 0) {
                    match++;
                }
                map.put(r, cnt);
            }
            if (right - left + 1 > p.length()) {
                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    int cnt = map.get(l);
                    cnt++;
                    if (cnt == 1) {
                        match--;
                    }
                    map.put(l, cnt);
                }
                left++;
            }
            if (map.size() == match) {
                result.add(left);
            }
            right++;
        }
        return result;
    }
}
