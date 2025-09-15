class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        int ans = 0;
        for (String word : words) {
            boolean flag = false;
            for (char ch : word.toCharArray()) {
                if (set.contains(ch)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) ans++;
        }
        return ans;
    }
}
