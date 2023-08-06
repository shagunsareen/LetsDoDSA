package dsa.with.shagun.scaler.advance.Stack.session1;

import java.util.Stack;

/*
There is a football event going on in your city. In this event, you are given A passes and players having ids between 1 and 106.

Initially, some player with a given id had the ball in his possession. You have to make a program to display the id of the player who possessed the ball after exactly A passes.

There are two kinds of passes:

1) ID

2) 0

For the first kind of pass, the player in possession of the ball passes the ball "forward" to the player with id = ID.

For the second kind of pass, the player in possession of the ball passes the ball back to the player who had forwarded the ball to him.

In the second kind of pass "0" just means Back Pass.

Return the ID of the player who currently possesses the ball.



Problem Constraints
1 <= A <= 100000

1 <= B <= 100000

|C| = A



Input Format
The first argument of the input contains the number A.

The second argument of the input contains the number B ( id of the player possessing the ball in the very beginning).

The third argument is an array C of size A having (ID/0).



Output Format
Return the "ID" of the player who possesses the ball after A passes.



Example Input
Input 1:

 A = 10
 B = 23
 C = [86, 63, 60, 0, 47, 0, 99, 9, 0, 0]
Input 2:

 A = 1
 B = 1
 C = [2]


Example Output
Output 1:

 63
Output 2:

 2


Example Explanation
Explanation 1:

 Initially, Player having  id = 23  posses ball.
 After pass  1,  Player having  id = 86  posses ball.
 After pass  2,  Player having  id = 63  posses ball.
 After pass  3,  Player having  id = 60  posses ball.
 After pass  4,  Player having  id = 63  posses ball.
 After pass  5,  Player having  id = 47  posses ball.
 After pass  6,  Player having  id = 63  posses ball.
 After pass  7,  Player having  id = 99  posses ball.
 After pass  8,  Player having  id = 9   posses ball.
 After pass  9,  Player having  id = 99  posses ball.
 After pass  10, Player having  id = 63   posses ball.
Explanation 2:

 Ball is passed to 2.
 */
public class PassingGame {
    public static void main(String[] args) {
        // System.out.println(solve(10, 23, new int[]{86, 63, 60, 0, 47, 0, 99, 9, 0, 0}));
        System.out.println(solve(10, 38, new int[]{23, 0, 2, 0, 39, 28, 19, 0, 0, 0}));
    }

    public static int solve(int A, int B, int[] C) {
        //A - no of passes
        //B - no. of players
        //C - players
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < C.length; i++) {
            if (C[i] != 0) {
                //insert ID into stack
                stack.push(C[i]); // this is the last player id who passed the bowl
            } else if (C[i] == 0 && !stack.empty()) {
                //pop ID from stack since we have to back pass i.e. last inserted element didn't pass
                // any ball instead we need to go to previous's previous element
                stack.pop();
            }
            A--;
            if (A < 0) {
                break;
            }
        }

        return !stack.empty() ? stack.peek() : B; //top element will be the last player with the ball in hand


        /*
        Short code as given in solution
        --Inserted B first since that will be the first player always so we don't have to check whether stack is empty or not
         **********************************************************
            Stack < Integer > st = new Stack < Integer > ();
            st.push(B);
            for (int x: C) {
                // pop from stack
                if (x == 0) st.pop();
                // push the given ID to stack
                else st.push(x);
            }
            return st.peek();
         **********************************************************
         */
    }
}
