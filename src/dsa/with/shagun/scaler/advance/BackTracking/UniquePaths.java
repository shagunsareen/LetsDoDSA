package dsa.with.shagun.scaler.advance.BackTracking;

import java.util.ArrayList;

public class UniquePaths {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int startRow = 0;
        int startCol = 0;
        int countCellToTraverse = 0;
        int rowSize = A.size();
        int colSize = A.get(0).size();

        //requirement is we have to cover all non-obstacle cells ie. 0 places starting from 1 to the ending square i.e. 2
        //once we find 1 from there we have to start we need to find all squares with 0'solve
        for(int i=0; i<rowSize; i++){
            //iterate on each row
            ArrayList<Integer> row = A.get(i);
            for(int j=0; j<row.size(); j++){
                if(row.get(j) == 1){
                    startRow = i;
                    startCol = j;
                    countCellToTraverse++;
                }else if(row.get(j) == 0){
                    countCellToTraverse++;
                }
            }
        }

        //Now we know where the starting point is and how many cells we have to traverse
        return getUniquePathCount(A, startRow, startCol, countCellToTraverse, 0, rowSize-1, colSize-1);
    }

    private int getUniquePathCount(ArrayList<ArrayList<Integer>> A, int startRow, int startCol, int countToTraverse, int countTraversed, int rowSize, int colSize){
        //break if the cell is out of bound
        if(startRow > rowSize || startRow < 0 || startCol > colSize || startCol < 0){
            return 0;
        }

        int currCellValue = A.get(startRow).get(startCol);
        if(currCellValue == -1){
            return 0;
        }

        if(currCellValue == 2){
            //check if we have traversed all the empty cells
            if(countToTraverse == countTraversed){
                return 1;
            }else{
                return 0;
            }
        }

        //DO - select the cell , mark it as -1 so that it should not be traversed again
        A.get(startRow).set(startCol, -1);
        countTraversed++;

        //traverse in all the 4 directions
        int c1 = getUniquePathCount(A, startRow, startCol+1, countToTraverse, countTraversed, rowSize, colSize); //RIGHT
        int c2 = getUniquePathCount(A, startRow + 1, startCol, countToTraverse, countTraversed, rowSize, colSize);//DOWN
        int c3 = getUniquePathCount(A, startRow, startCol-1, countToTraverse, countTraversed, rowSize, colSize); //LEFT
        int c4 = getUniquePathCount(A, startRow - 1, startCol ,countToTraverse, countTraversed, rowSize, colSize); //UP

        //UNDO -- if we backtrack lets set it back to 0
        A.get(startRow).set(startCol, 0);
        countTraversed--;

        return (c1+c2+c3+c4);
    }
}
