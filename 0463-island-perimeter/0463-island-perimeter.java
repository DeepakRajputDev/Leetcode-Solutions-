class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int peri =0;
        for(int i=0; i<row ; i++){
            for(int j=0; j<col ; j++){
                //All 4 condition
                //Up
                if(grid[i][j]==1){
                    if(i-1<0) peri++;
                    else{
                        if(grid[i-1][j]==0) peri++;
                    }
                    //Down
                        if(i+1==row) peri++;
                        else{
                            if(grid[i+1][j]==0) peri++;
                        }
                //Right
                //Up
                    if(j-1<0) peri++;
                    else{
                        if(grid[i][j-1]==0) peri++;
                    }
                    //Down
                    if(j+1==col) peri++;
                    else {
                        if(grid[i][j+1]==0) peri++;
                    }
                }
            }
        }
        return peri;
    }
}