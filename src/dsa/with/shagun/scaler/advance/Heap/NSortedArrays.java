package dsa.with.shagun.scaler.advance.Heap;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NSortedArrays {

    /*class Pair {
        int val;
        IndexPair indexes;

        Pair(int nodeVal, IndexPair indexPair){
            this.val = nodeVal;
            this.indexes = indexPair;
        }

    }
    class IndexPair{
        int rowIndex;
        int colIndex;

        IndexPair(int ri, int ci){
            this.rowIndex = ri;
            this.colIndex = ci;
        }
    }
*/
    class Pair {
        int rowIndex;
        int colIndex;

        Pair(int rowIndex, int colIndex){
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

    }

    //Function to merge k sorted arrays.
    public int[] solve(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        int[] ans = new int[rows*columns];

        //Min Heap
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x,y) -> A[x.rowIndex][x.colIndex] - A[y.rowIndex][y.colIndex]);

        // Insert first column elements into the heap (N elements into heap)
        for (int i = 0; i < rows; i++) {
            minHeap.add(new Pair(i, 0)); // Row_index, Col_index
        }

        int q=0;
        while (!minHeap.isEmpty()) {

            Pair pair = minHeap.peek();

            int rowIndex = pair.rowIndex;
            int colIndex = pair.colIndex;
            int data = A[rowIndex][colIndex];

            ans[q] = data;
            q++;
            minHeap.poll(); // delete the min element and move pointer to next element for that row

            if (colIndex + 1 < columns) {
                minHeap.add(new Pair(rowIndex, colIndex + 1)); // insert next element to minheap
            }
        }

        return ans;

    }
}
