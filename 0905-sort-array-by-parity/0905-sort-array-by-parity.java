class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int n=arr.length;
        int[] res=new int[n];
        int k=0;

        for(int i=0;i<n;i++){
         if(arr[i]%2==0){
            res[k]=arr[i];
            k++;
         }
        }

        for(int i=0;i<n;i++){
            if(arr[i]%2!=0){
                res[k]=arr[i];
                k++;
            }
        }

        return res;
    }
}