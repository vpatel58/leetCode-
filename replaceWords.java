class Solution {

    class TrieNode {
        TrieNode[] child;
        boolean isEnd;
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
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String s : dictionary) {
            insert(s);
        }
        String[] str = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (i != 0) result.append(" ");
            String word = str[i];
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.child[idx] == null || curr.isEnd == true) {
                    break;
                }
                sb.append(ch);
                curr = curr.child[idx];
            }
            if (curr.isEnd) result.append(sb.toString());
            else result.append(word);
        }
        return result.toString();
    }
}
