package dsa.with.shagun.scaler.advance.BinarySearch.session3;

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        //System.out.println(paint(2, 5, new int[]{1, 10}));
        //System.out.println(paint(10, 1, new int[]{1, 8, 11, 3}));
        System.out.println(paint(4, 10, new int[]{884, 228, 442, 889}));
    }

    /* There are A painters available and each of them takes B units of time to paint 1 unit of the board.
    Element C[i] represents the length of ith board.
    You have to paint all N boards [C0, C1, C2, C3 … CN-1]. */
    public static int paint(int A, int B, int[] C) {
        //First decide search space

        long ans = 0;
        // if no. of workers == no. of tasks, each worker takes that task value as time taken.
        // Total time would be the time taken by worker to complete max. value task since all workers start at same time
        long l = getMax(C);

        //If we have only 1 worker who has to complete all the tasks, then he will do all tasks one by one i.e. time taken would be sum of time taken for all the tasks.
        int[] prefixSumArr = getPrefixSumArr(C);
        long r = prefixSumArr[C.length - 1]; // since last element should have sum of all the elements

        while (l <= r) {
            long mid = l + (r - l) / 2;  // time taken values

            //check if mid as min. time is possible to paint all board tasks
            if (checkMidTimeFeasibility(prefixSumArr, A, mid)) {
                //let's go left as we need min. time
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1; // let's go right since if it is not possible in mid time then for any time lesser than mid also it won't be possible
            }
        }
        return (int) (ans * B % 10000003);
    }

    private static boolean checkMidTimeFeasibility(int[] pf, int a, long mid) {
        //if in prefix array we are able to get sum as >=mid then decrement
        int numPainters = a;
        int posPainters = 0;
        numPainters--; // since painter 1 will start from pos 0 always

        //let's find if we can place other painters in mid time
        for (int i = 1; i < pf.length; i++) {//we will check value at each stall whether it equals mid calculated
            if (posPainters == 0) {
                if (pf[i] > mid)  // prefix sum in range is always prefix[right] - prefix[left-1], Since for 0 there is no left hence consider just prefix[right]
                {
                    numPainters--;
                    posPainters = i;
                }
            } else {
                if (pf[i] - pf[posPainters - 1] > mid)  //prefix sum in range is always prefix[right] - prefix[left-1]
                {
                    numPainters--;
                    posPainters = i;
                }

            }

        }
        //System.out.println("Mid : " +mid + "- Painters : "+numPainters);

        if (numPainters >= 0) {   // These number of painters should be positive since we should have enough painters to paint in given time
            return true;
        }
        return false;
    }

    private static int getMax(int[] C) {
        int max = Integer.MIN_VALUE;
        for (int i : C) {
            max = Math.max(i, max);
        }
        return max;
    }

    private static int[] getPrefixSumArr(int[] C) {
        int[] prefixSumArr = new int[C.length];
        prefixSumArr[0] = C[0];
        for (int i = 1; i < C.length; i++) {
            prefixSumArr[i] = prefixSumArr[i - 1] + C[i];
            //System.out.println(prefixSumArr[i]);
        }
        return prefixSumArr;
    }
}
