class Solution {
    class TrieNode {
        TrieNode[] child;
        boolean isEnd;
        String word;
        TrieNode() {
            child = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
        }
        curr.word = word;
    }
    StringBuilder result;
    public String longestWord(String[] words) {
        root = new TrieNode();
        result = new StringBuilder();
        if (words == null || words.length == 0) return "";
        for (String word : words) {
            insert(word);
        }
        //dfs
        helper(root, new StringBuilder());
        return result.toString();
    }

    public void helper(TrieNode root, StringBuilder sb) {

        if (root.word != null && result.length() < sb.length()) {
            result.setLength(0);
            result.append(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null && root.child[i].word != null) {
                sb.append((char) (i + 'a'));
                helper(root.child[i], sb);
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            }
        }
    }
}
