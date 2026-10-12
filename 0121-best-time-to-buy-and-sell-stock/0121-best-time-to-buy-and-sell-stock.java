class Solution {
    public int maxProfit(int[] arr) {
       int n = arr.length;
       int currp =0;
       int minp = arr[0];
       int maxp =0;
       for(int i=0; i<n ; i++){
        currp = arr[i]-minp;
        maxp = Math.max(maxp , currp);
        minp = Math.min(minp,arr[i]);
       }
       return maxp;
    }
}