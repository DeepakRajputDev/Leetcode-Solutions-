class Solution {
    public int maximum69Number (int num) {
    int rev = 0;
    while(num > 0){
        int ld = num % 10;
        rev = rev * 10 +ld;
        num = num / 10;
    }   
    int rev1 = 0;
    int c6 = 0;
    while(rev > 0){
        int ld = rev % 10;
        if(ld == 6 && c6 < 1){
            c6++;
            ld = 9;
        }
        rev1 = rev1 * 10 + ld;
        rev = rev / 10;
    } 
    return rev1;
    }
}