class Solution {
    HashMap<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            map.put(ch, i);
        }
        for (int i = 0; i < n - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            if (isNotSorted(first, second)) return false;
        }
        return true;
    }
    public boolean isNotSorted(String first, String second) {
        int m = first.length();
        int n = second.length();
        for (int i = 0; i < m && i < n; i++) {
            char fChar = first.charAt(i);
            char sChar = second.charAt(i);
            if (fChar != sChar) {
                return map.get(fChar) > map.get(sChar);
            }
        }
        if (m > n) return true;
        return false;
    }
}
