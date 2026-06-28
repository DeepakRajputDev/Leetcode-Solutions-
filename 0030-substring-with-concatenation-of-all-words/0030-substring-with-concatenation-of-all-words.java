import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int n = s.length();
        
        // Count frequency of each word
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Iterate through each possible offset to cover all starting positions
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int left = i;
            int count = 0;

            // Slide the window across the string in increments of wordLen
            for (int right = i; right <= n - wordLen; right += wordLen) {
                String word = s.substring(right, right + wordLen);
                
                if (wordCounts.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;
                    
                    // If a word is seen more than required, shrink window from left
                    while (seenWords.get(word) > wordCounts.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    // Check if all words are found
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Reset if current word is not in the list
                    seenWords.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return result;
    }
}