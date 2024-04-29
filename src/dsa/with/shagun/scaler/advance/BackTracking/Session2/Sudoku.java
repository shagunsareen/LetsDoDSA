package dsa.with.shagun.scaler.advance.BackTracking.Session2;

public class Sudoku {
    public void solveSudoku(char[][] A) {
        int n = A.length;
        sudoku(A, n, 0, 0);
    }

    private boolean sudoku(char[][] A, int size, int row, int col){
        if(col == size){
            return sudoku(A, size, row+1, 0); //go and fill next row
        }

        if(row == size){ //when all rows are covered then return true
            return true;
        }

        if(A[row][col] != '.'){
            return sudoku(A, size, row, col+1); //go to the next column
        }

        for(char num = '1'; num <= '9'; num++)
        {
            if(isValidPlacement(A, row, col, num))
            {
                //if valid then insert the value
                A[row][col] = num; //DO STEP

                //Go and fill next column
                if(sudoku(A, size, row, col+1)){
                    return true;
                }

                A[row][col] = '.'; //UNDO STEP
            }
        }
        return false; //if nothing is possible return false
    }


    private boolean isValidPlacement(char[][] A, int row, int col, char val){
        //check in the entire row and col
        for(int i=0; i<A.length; i++){
            if(A[row][i] == val) return false;
            if(A[i][col] == val) return false;
        }

        //check for the subgrid values
        int p = (int) Math.sqrt(A.length);
        int subGridRow = row - row % p;
        int subGridCol = col - col % p;

        for(int i=0; i<p; i++){
            for(int j=0; j<p; j++){
                int x1 = subGridRow + i;
                int y1 = subGridCol + j;

                if(A[x1][y1] == val) return false;
            }
        }
        return true;
    }
}
