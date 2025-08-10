class Solution {
    HashMap<String, Integer> map;
    String beginWord;
    String endWord;
    List<List<String>> result;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        map = new HashMap<>();
        result = new ArrayList<>();
        this.beginWord = beginWord;
        this.endWord = endWord;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        map.put(beginWord, 0);
        while (!q.isEmpty()) {
            String word  = q.poll();
            int steps = map.get(word);
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char original = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String curr = String.valueOf(arr);
                    if (set.contains(curr)) {
                        set.remove(curr);
                        q.add(curr);
                        map.put(curr, steps + 1);
                    }
                }
                arr[i] = original;
            }
        }

        if (map.containsKey(endWord)) {
            List<String> list = new ArrayList<>();
            list.add(endWord);
            dfs(endWord, list);
        }
        return result;
    }

    public void dfs(String word, List<String> seq) {
        if (word.equals(beginWord)) {
            Collections.reverse(seq);
            result.add(new ArrayList<>(seq));
            Collections.reverse(seq);
            return;
        }
        int steps = map.get(word);
        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char original = arr[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;
                String curr = String.valueOf(arr);
                if (map.containsKey(curr) && map.get(curr) + 1 == steps) {
                    seq.add(curr);
                    dfs(curr, seq);
                    seq.removeLast();
                }
            }
            arr[i] = original;
        }
    }
}
