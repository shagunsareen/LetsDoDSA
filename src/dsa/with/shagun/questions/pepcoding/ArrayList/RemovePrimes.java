package dsa.with.shagun.questions.pepcoding.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimes {
    public static void solution(ArrayList<Integer> al) {
        for (int j = al.size() - 1; j >= 0; j--) {
            int element = al.get(j);
            boolean flag =  true;
            for (int i = 2; i * i <= element; i++) {
                if ((i != element) && (element % i == 0)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                al.remove(j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }
}
