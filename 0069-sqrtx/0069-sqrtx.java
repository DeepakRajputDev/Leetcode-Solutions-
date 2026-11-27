class Solution {
    public int mySqrt(int n) {
        if(n==0)return 0;
        int low=1;
        int high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            long sqr=(long)mid*mid;
            if(sqr==n){
                return mid;
            }
            else if(sqr>n){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return high;
    }
}