class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxResult = new int[k];
        
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] sub1 = getMaxSubsequence(nums1, i);
            int[] sub2 = getMaxSubsequence(nums2, k - i);
            int[] candidate = merge(sub1, sub2);
            if (isGreater(candidate, 0, maxResult, 0)) {
                maxResult = candidate;
            }
        }
        return maxResult;
    }

    private int[] getMaxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1;
        int drop = nums.length - k;
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                drop--;
            }
        }
        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (k < merged.length) {
            if (isGreater(nums1, i, nums2, j)) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        return merged;
    }

    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}