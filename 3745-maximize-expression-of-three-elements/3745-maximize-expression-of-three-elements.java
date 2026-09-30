class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
      int n = nums.length;
      Arrays.sort(nums);
      int a = nums[n-1];
       int b = nums[n-2]; 
       int c = nums[0];
       return a+b-c;
    }
}