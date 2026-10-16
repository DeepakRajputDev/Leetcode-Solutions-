class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        
        HashSet<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
            if (set.size() == 26) {
                return true;
            }
        }
        return false;
    }
}