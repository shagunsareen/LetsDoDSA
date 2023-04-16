package dsa.with.shagun.scaler.array.InterviewQuestions;

public class MaximumPositivity {
    public int[] solve(int[] A) {
        int start = 0;
        int end = 0;
        int maxLen = Integer.MIN_VALUE;
        int minStart = start;
        int len = 0;
        int n = A.length;

        while(end < n){
            if(A[end] >= 0)  //checking if it is a positive number then increase length by 1
            {
                len++;
            }else{  // negative integers encountered so start subarray from next element
                if(len > maxLen){
                    maxLen = len;
                    minStart = start;
                }else if(len == maxLen){
                    minStart = Math.min(minStart, start);
                }
                start = end+1;
                len = 0;
            }
            //System.out.println("S : "+start+", E : "+end+", length : "+len+" minStart : "+minStart+", maxLen : "+maxLen);
            end++;
        }

        if(len > maxLen){
            maxLen = len;
            minStart = start;
        }else if(len == maxLen){
            minStart = Math.min(minStart, start);
        }

        if(maxLen==Integer.MIN_VALUE){
            maxLen = n;
            end = n-1;
        }

        int[] res = new int[maxLen];

        //iterate over array and return the ans
        for(int k=0; k<maxLen; k++){
            res[k] = A[minStart];
            //System.out.println("Element Inserted : "+ res[k] + "Ele to be inserted : "+A[minStart]);
            minStart++;
        }
        return res;
    }
}
