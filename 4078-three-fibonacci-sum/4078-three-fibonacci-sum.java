class Solution {
    // Time Complexity - o(n)
    // Space complexity o(1)
    public boolean checkFibbo(int n){
        int a = 0; 
        int b = 1;
        int sum = 0;
        while(sum < n){
            sum = a + b;
            a = b;
            b = sum;
        }
        if(sum == n)
            return true;
            else return false;
        
    }
    public boolean threeFibonacciSum(int n) {
        if(n % 2 != 0)
            return false;
        int x = n /2;
        return checkFibbo(x);
    }
}