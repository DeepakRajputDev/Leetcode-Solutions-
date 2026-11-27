class Solution {
    public int findMin(int[] nums){
        int n = nums.length;
        int low =0;
        int high =n-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[high]) low =mid+1;
            else high =mid;
        }
        return low;
    }
    public int bs(int[] nums,int low , int high,int target){
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int min = findMin(nums);
        int idx1 = bs(nums,0,min-1,target);
        int idx2 = bs(nums,min,n-1,target);
        if(idx1!=-1) return idx1;
        else return idx2;
    }
}