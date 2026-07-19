class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) return 0;
        
        long x = 0;
        long sum = 0;
        long multiplier = 1;
       
        int temp = n;
        
       
        java.util.List<Integer> digits = new java.util.ArrayList<>();
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 0) {
                digits.add(digit);
            }
            temp /= 10;
        }
        
       
        for (int i = digits.size() - 1; i >= 0; i--) {
            int d = digits.get(i);
            x = x * 10 + d;
            sum += d;
        }
        
        return x * sum;
    }
}