package dsa.with.shagun.leetcode.PFD24.Array;

public class TimeToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ticketsToBuy = tickets[k];
        int timeTaken = 0;

        while(ticketsToBuy > 0){
            for(int i = 0; i<tickets.length; i++){
                if(tickets[i] > 0){
                    tickets[i]--;
                    timeTaken++;
                }

                //if all tickets for k are bought then no need to move forward in the loop
                if(tickets[k] == 0){
                    return timeTaken;
                }
            }
            ticketsToBuy--;
        }
        return timeTaken;
        //TC : O(n.m), SC : O(1)
    }
}
