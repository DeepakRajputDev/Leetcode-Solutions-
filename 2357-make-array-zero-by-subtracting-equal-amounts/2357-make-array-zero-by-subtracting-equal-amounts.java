class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int ele:nums){
            if(ele !=0){
                set.add(ele);
            }
        }
        return set.size();
    }
}