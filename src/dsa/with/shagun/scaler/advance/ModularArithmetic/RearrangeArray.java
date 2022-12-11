package dsa.with.shagun.scaler.advance.ModularArithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RearrangeArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        arrange((ArrayList<Integer>) list);
    }

    public static void arrange(ArrayList<Integer> a) {
        /*int range = A.size();
        A  = (ArrayList<Integer>) A.stream().map(i->i*range).collect(Collectors.toList());
        A.stream().map(i-> A.get(i)/range).collect()*/

       /* Object[] A =  a.toArray();
        int range = A.length;

        //Step1 : multiple each element by range
        for(int i=0; i<range; i++){
            A[i] = A[i]*range;
        }

        //Step2 : replace arr[i] by arr[arr[i]]. Since we have multiplied range in first step divide it everywhere while accessing number
        for(int i=0; i<range; i++){
            A[i] += A[A[i]/range]/range;
        }

        //Step3 : Take modulo by range to get new data
        for(int i=0; i<range; i++){
            A[i] = A[i]%range;
        }

       a = (ArrayList<Integer>) Arrays.stream(A).collect(Collectors.toList());*/

        int n = a.size();
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) * n);
        }

        for (int i = 0; i < n; i++) {
            a.set(i,  a.get(i) + a.get(a.get(i)/n)/n);  //since we mutiplied every number by n in step1
        }

        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i)%n);
        }

    }

}
