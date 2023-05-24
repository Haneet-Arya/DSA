class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n;i++){
            for(int j = 0; j<n;j++){
                board[i][j]='.';
            }
        }
        nQueens(board,0);;
        return res;
    }
    public void nQueens(char[][] board,int row){
        if(row==board.length){
            List<String> ret = new ArrayList<>();
            for(int i = 0; i < board.length;i++){
                ret.add(new String(board[i]));
            }
            res.add(ret);
            return;
        }
        for(int i = 0; i < board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i] = 'Q';
                nQueens(board,row+1);
                board[row][i] = '.';
            }
        }

    }
    public boolean isSafe(char[][] board, int row, int col){
        for(int i = row-1;i>=0;i--){
            if(board[i][col]=='Q') return false;
        }
        for(int i = row-1,j=col-1; i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i = row-1,j=col+1; i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}