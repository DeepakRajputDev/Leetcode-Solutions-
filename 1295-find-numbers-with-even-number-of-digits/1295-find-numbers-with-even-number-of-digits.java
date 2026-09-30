class Solution {
    public boolean check (int n){
        int count = 0;
        while(n > 0){
            count++;
            n = n / 10;
        }
        return count % 2 == 0;
      }
    public int findNumbers(int[] nums) {
      int n = nums.length;
      int count = 0;
      for(int ele:nums){
        if(check(ele)){
            count++;
        }
      }
      return count;
    }
}