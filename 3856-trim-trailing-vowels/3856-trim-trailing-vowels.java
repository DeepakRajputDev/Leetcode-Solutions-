class Solution {
    public String trimTrailingVowels(String s) {
     int n = s.length();
     String vowels = "aeiou";
     int count = 0;
      for(int i = n-1; i >= 0; i--){
       char ch = s.charAt(i);
       if(vowels.indexOf(ch)!= -1) count++;
       else break;
      }
     return s.substring(0, n-count); 
    }
}