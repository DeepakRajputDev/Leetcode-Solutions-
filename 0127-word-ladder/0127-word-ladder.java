class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                char[] chars = current.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[j] = c;
                        String transformed = new String(chars);
                        if (transformed.equals(endWord)) return level + 1;
                        if (wordSet.contains(transformed)) {
                            queue.offer(transformed);
                            wordSet.remove(transformed);
                        }
                    }
                    chars[j] = original;
                }
            }
            level++;
        }
        
        return 0;
    }
}