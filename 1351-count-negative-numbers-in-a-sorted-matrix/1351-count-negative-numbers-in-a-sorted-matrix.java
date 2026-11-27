class Solution {
    public int countNegatives(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int count =0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col ; j++){
                if(arr[i][j]<0) count++;
            }
        }
        return count;
    }
}