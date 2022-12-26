package dsa.with.shagun.scaler.advance.Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        //TC :O(2^N) since recursive relation f(N) = 2f(N-1)+1  that will lead to O(2^N),
        // SC:O(N) since max recursion stack size will be N
        towerOfHanoi(3, 'A', 'B', 'C');
    }

    public static void towerOfHanoi(int n, char source, char temp, char destination) {
        if (n == 0) {
            return;
        }
        /*
        transfer n-1 (2 disks) from tower1 (source) to tower2(temp) using tower3 (destination)
         */
        towerOfHanoi(n - 1, source, destination, temp);

        //now transfer the third (nth) disk from tower1 to tower3 as it is the biggest disc
        System.out.println(n + "[" + source + "->" + destination + "]");

        /*
        transfer disks moved to tower2(temp) in Step1 from tower2 to tower3(destination) using tower1(source)
         */
        towerOfHanoi(n - 1, temp, source, destination);
    }
}
