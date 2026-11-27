class Solution {
    public boolean isPerfectSquare(int n) {
        if(n==0)return true;
        int low=1;
        int high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            long sqr=(long)mid*mid;
            if(sqr==n){
                return true;
            }
            else if(sqr<n){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
        
    }
}