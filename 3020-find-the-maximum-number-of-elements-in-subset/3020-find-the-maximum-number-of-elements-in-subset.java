import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put((long) num, counts.getOrDefault((long) num, 0) + 1);
        }

        int maxLen = 0;
        
        if (counts.containsKey(1L)) {
            int ones = counts.get(1L);
            maxLen = (ones % 2 == 0) ? ones - 1 : ones;
        }

        for (long key : counts.keySet()) {
            if (key == 1L) continue;
            
            long curr = key;
            int count = 0;
            while (counts.containsKey(curr) && counts.get(curr) >= 2) {
                count += 2;
                curr *= curr;
            }
            
            if (counts.containsKey(curr)) {
                count += 1;
            } else {
                count -= 1;
            }
            
            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }
}