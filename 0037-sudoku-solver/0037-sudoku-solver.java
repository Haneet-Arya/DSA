class Solution {
    public void solveSudoku(char[][] board) {
        sudokuHelper(board, 0, 0);
    }
    public boolean sudokuHelper(char[][] board, int row, int col){
        if(row==9) return true;
        int newRow = row;
        int newCol = col+1;
        if(newCol==9){
            newRow=row+1;
            newCol=0;
        }
        if(board[row][col]!='.'){
            return sudokuHelper(board,newRow,newCol);
        }
        for(char i = '1'; i <= '9';i++){
            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                if(sudokuHelper(board, newRow, newCol)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, char digit){
        // in the row
        for(int i = 0; i < 9;i++){
            if(board[row][i]==digit){
                return false;
            }
        }

        // in the column
        for(int i = 0; i < 9; i++){
            if(board[i][col]==digit){
                return false;
            }
        }

        // in the grid
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i = startRow; i < startRow+3;i++){
            for(int j = startCol; j<startCol+3; j++){
                if(board[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
}