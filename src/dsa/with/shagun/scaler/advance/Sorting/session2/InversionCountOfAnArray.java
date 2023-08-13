package dsa.with.shagun.scaler.advance.Sorting.session2;

public class InversionCountOfAnArray {

        long mod = 1000000007;
        long inversionCount = 0;

        public int solve(int[] A) {
            //Divide array into 2 halfs
            mergeSort(A, 0, A.length-1);
            return (int) (inversionCount % mod);
        }

        private int[] mergeSort(int[] arr, int start, int end){
            if(start == end){
                int[] smallArr = new int[1];
                smallArr[0] = arr[start];
                return smallArr;
            }

            int mid = (start + end)/2;
            //System.out.println("Start : " + start + ", End : "+end + " , Mid : "+mid);

            //now divide the array into 2 halves this will divide the array till single element
            int[] A = mergeSort(arr, start, mid);
            int[] B  = mergeSort(arr, mid+1, end);

            //now merge the arrays , now actual sorting will take place and then we merge the arrays
            return merge(A, B);
        }

        private int[] merge(int[] arr, int[] arr1){
            //System.out.println("Inside  merge, Start : " + start + ", End : "+end + " , Start2 : " + start2 + ", End2 : "+end2);
            int n1 = arr.length;
            int n2 = arr1.length;

            //System.out.println("N1 : "+ (end-start+1));

            int[] arr2 = new int[n1 + n2]; // new array length is combination of both the arrays
            int n3 = arr2.length;

            int index = 0;
            int start = 0;
            int start2 = 0;
            while(start < n1 && start2 < n2){
                //System.out.println(" left : "+ arr[start] + ", - right : "+ arr[start2]);

                //compare and check which element is smaller so that we can insert that first
                if(arr[start] <= arr1[start2]){
                    //System.out.println("NO Count : "+inversionCount + ", left : "+ arr[start] + ", - right : "+ arr[start2]);
                    // meaning left element is smaller then insert that in the new array
                    arr2[index] = arr[start];
                    start++;
                }else{
                    //if left value is greater than the right value then we got the inversion pair
                    // here how many elements are on the right of current element also depends since we are taking sorted arrays
                    // so if right arr element is smaller than current element , it is also smaller than right elements of left arr
                    // so we need to count that as well.
                    // Hence when we get any such pair we need to check elements on right as well
                    arr2[index] = arr1[start2];
                    inversionCount += (n1-start);  // no. of elements on the right of current index which are greater than arr[start2]
                    //System.out.println("Count : "+inversionCount + ", left : "+ arr[start] + ", - right : "+ arr[start2]+ ",start : "+start+" - eles : "+ (n1-start));
                    start2++;
                }
                index++;
            }

            //incase elements of only left arr are left, then insert those elements
            while(start<n1){
                arr2[index] = arr[start];
                index++;
                start++;
            }

            while(start2 < n2){
                arr2[index] = arr1[start2];
                index++;
                start2++;
            }

            return arr2;
        }
}
