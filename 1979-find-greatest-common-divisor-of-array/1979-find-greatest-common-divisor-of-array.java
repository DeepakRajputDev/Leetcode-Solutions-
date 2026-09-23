class Solution {
    public int gcd(int a, int b){
        int gcd = 1;
        for(int i = a; i >= 1; i--){
            if(a % i == 0 && b % i == 0){
            gcd = i;
            break;
        }
    }
    return gcd;
    }
    public int findGCD(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
    return gcd(nums[0],nums[n-1]);
    }
}