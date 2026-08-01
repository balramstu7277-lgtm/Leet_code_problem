class Solution {
    static int check = 0;
    public void solver(char[][] board, int row, int col) {
        if(row == 9){
            check = 1;
            return;
        }
        else if (board[row][col] != '.') { //call
            if (col != 8) {
                solver(board, row, col + 1 );
            } else {
                solver(board, row + 1, 0);
            }

        } else { // baorad[row][col] = '.'
            for (char ch = '1'; ch <='9'; ch++) {
                if (isvalid(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (col != 8) solver(board, row, col + 1);
                    else solver(board, row + 1, 0);
                    if(check ==  1) return ;
                    board[row][col] = '.'; // backtracking     
                }

            }
        }

    }
    public boolean isvalid(char[][] board , int row , int col , char ch){
        // check row 
        for(int j = 0 ; j < 9 ;j++){
            if(board[row][j] == ch ) return false ;
        }

        // check col 
        for(int i = 0 ; i < 9 ;i++){
            if(board[i][col]== ch) return false ;
        }

        // check 3 by 3 grid 
        int sRow = row/3*3;
        int sCol = col/3*3;
        for(int i = sRow ;i < sRow+3;i++){
            for(int j = sCol; j < sCol+3 ;j++){
                if(board[i][j]== ch) return false ;
            }
        }
        return true;  
    }
    public void solveSudoku(char[][] board) {
        solver(board, 0, 0 );
        check =0;
        
    }
}