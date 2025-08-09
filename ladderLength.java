class Solution {
    class Pair {
        String word;
        int seq;
        Pair(String word, int seq) {
            this.word = word;
            this.seq = seq;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++)
            set.add(wordList.get(i));
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int seq = p.seq;
            if (word.equals(endWord)) return seq;
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char original = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String curr = String.valueOf(arr);
                    if (set.contains(curr)) {
                        set.remove(curr);
                        q.add(new Pair(curr, seq + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}
