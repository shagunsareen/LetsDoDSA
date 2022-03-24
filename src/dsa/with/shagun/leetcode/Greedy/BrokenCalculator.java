package dsa.with.shagun.leetcode.Greedy;

public class BrokenCalculator {
    public static void main(String[] args) {
        System.out.println(brokenCalc(2,15));
    }

    public static int brokenCalc(int startValue, int target) {
        if(startValue >= target){
            return startValue - target;
        }
        if(target %2 ==0){
            return 1 + brokenCalc(startValue, target/2);
        }
        return 1 + brokenCalc(startValue, target+1);
    }
}
