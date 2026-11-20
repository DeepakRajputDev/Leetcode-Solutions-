class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int minIdx = findMin(nums);
        
        // Check which sorted half the target falls into
        if (target >= nums[minIdx] && target <= nums[n - 1]) {
            return binarySearch(nums, target, minIdx, n - 1);
        } else {
            return binarySearch(nums, target, 0, minIdx - 1);
        }
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}