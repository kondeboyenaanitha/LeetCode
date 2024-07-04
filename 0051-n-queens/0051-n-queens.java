class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board,0);
        return ans;

    }

    public static boolean isSafe(char board[][], int row, int col){
        //vertical up
        for (int i = row-1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //diagonal left up
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //diagonal right up
        for (int i = row-1, j = col+1; i >= 0 && j < board.length; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void nQueens(char board[][], int row){
        //base
        if (row == board.length) {
            printBoard(board);
            return;
        }
        //column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row+1); //function call
                board[row][j] = '.';   //backtracking step
            }
        }
    }

    public void printBoard(char board[][]){
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String str = "";
            for (int j = 0; j < board.length; j++) {
                str += board[i][j];
            }
            ls.add(str);
        }
        ans.add(ls);
    }
}