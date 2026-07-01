class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] lastIndex = new int[128];
        java.util.Arrays.fill(lastIndex, -1);

        for (int right = 0, left = 0; right < n; right++) {
            char c = s.charAt(right);
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }
            lastIndex[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}