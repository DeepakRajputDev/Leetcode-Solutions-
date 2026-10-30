class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        return (num % 9 == 0) ? 9 : (num % 9);
        // if(num<=9) return num;
        // else{
        //     int sum = 0;
        //     while(num!=0){
        //         sum = sum +num%10;
        //         num = num/10;
        //     }
        //     return addDigits(sum);
        // }
    }
}