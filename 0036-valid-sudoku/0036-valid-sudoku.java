class Solution {
    public boolean checkValid(char[][] board,int row, int col, char ch){
        // for rowa
        for(int j = 0; j < 9; j++){
            if(board[row][j] == ch)
            return false;
        }
        // for cols
         for(int i = 0; i < 9; i++){
            if(board[i][col] == ch)
            return false;
        }
        int rGrid = row/3*3;
        int cGrid = col/3*3;
        for(int i = rGrid; i < rGrid +3; i++){
            for(int j = cGrid; j < cGrid +3; j++){
                if(board[i][j] == ch)
                return false;
            }
        }
    return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
for(int j = 0; j < 9; j++){
    if(board[i][j] != '.'){ // '1' --> '9'
char ch = board[i][j]; // '6'
board[i][j] ='.';
if(checkValid(board,i,j,ch) == false)
return false;
board[i][j] = ch;
    }
}
        }
        return true;
    }
}