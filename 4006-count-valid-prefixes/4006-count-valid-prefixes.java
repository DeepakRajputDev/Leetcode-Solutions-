class Solution {
    public int countValidPrefixes(String s) {
     Scanner sc = new Scanner(System.in);
     int c1 = 0;
     int c2 = 0;
     int n = s.length();
     int ans = 0;
     for(int i = 0; i < n; i++){
        if(s.charAt(i) == '0') c1++;
        else c2++;
        if(Math.abs(c1 - c2) <=1) ans++;
     }   
     return ans;
    }
}