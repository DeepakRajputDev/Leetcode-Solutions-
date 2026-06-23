class Solution {
    public boolean judgeCircle(String moves) {
        int l = 0, r = 0, u = 0, d = 0;
        
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            if (move == 'L') l++;
            else if (move == 'R') r++;
            else if (move == 'U') u++;
            else if (move == 'D') d++;
        }
        
        return (l == r && u == d);
    }
}