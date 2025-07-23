class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return result;
        backtrack(digits, 0);
        return result;
    }

    private void backtrack(String digits, int idx) {
        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(idx));
        for (char ch : letters.toCharArray()) {
            sb.append(ch);
            backtrack(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
