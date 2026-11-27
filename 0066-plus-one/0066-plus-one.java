class Solution {
    public int[] plusOne(int[] nums) {
        int n = nums.length;
        int[] res = new int[n+1];
        for(int i=n-1; i>=0; i--){
            if(nums[i]<=8){
                nums[i] = nums[i]+1;
                return nums;
            }
            else{
                nums[i] =0;
            }

        }
        res[0] =1;
        return res;
    }
}