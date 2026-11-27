class Solution {
    public int maximumWealth(int[][] acc) {
        int row=acc.length;
        int col=acc[0].length;
        int max=0;
        for(int i=0; i<row; i++){
            int sum=0;
            for(int j=0; j<col; j++){
                sum=sum+acc[i][j];
                

            }
            max=Math.max(max,sum);
        }
        return max;
        
    }
}