class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxV = 0;
        int maxC = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                maxV = Math.max(maxV, map.get(ch));
            } else {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                maxC = Math.max(maxC, map.get(ch));
            }
        }
        return maxV + maxC;
    }
}
