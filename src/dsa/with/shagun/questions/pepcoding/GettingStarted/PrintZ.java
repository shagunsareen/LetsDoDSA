package dsa.with.shagun.questions.pepcoding.GettingStarted;

public class PrintZ {
    public static void main(String[] args) {
        int n =5;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n-1; j++) {
                if (i == 1 || i == n) {
                    System.out.print('*');
                }else if(j == n-i){
                    System.out.print('*');
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
