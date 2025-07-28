class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                result.add(sub);
            }
            set.add(sub);
        }
        return new ArrayList<>(result);
    }
}
