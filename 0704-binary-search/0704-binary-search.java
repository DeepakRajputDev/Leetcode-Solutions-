class Solution {
    public int binarySearch(int[] nums,int low,int high,int t){
        if(low>high) return -1;
        int mid = low +(high-low)/2;
        if(nums[mid]==t) return mid;
        else if(nums[mid]>t) return binarySearch(nums,low,mid-1,t);
        else return binarySearch(nums,mid+1,high,t);
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        return binarySearch(nums,0,n-1,target);
    }
}