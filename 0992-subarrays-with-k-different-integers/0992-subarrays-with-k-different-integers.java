class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        //Take a hashmap and store the frequency of every element in first iteration of every subarray of first element
        //then iterate over the elements one by one and delete the previous element, compare size of hashmap to K and increment the count
        
        /*
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        int arrSize = nums.length;

        for(int i=0; i<arrSize; i++){
            int currElement = nums[i];
            if(!freqMap.containsKey(currElement)){
                freqMap.put(currElement, 1);
            }else{
                freqMap.put(currElement, freqMap.getOrDefault(currElement, 0) + 1);
            }
            
            if(freqMap.size()==k){
                count++;
            }
        }

        for(int i=1; i<arrSize; i++){
            
            int prevEle = nums[i-1];
            int frequency = freqMap.getOrDefault(prevEle, 0);

            System.out.println("Frequency : " + frequency);
            if (frequency > 0) {
                freqMap.put(prevEle, frequency - 1); // Decrement frequency
                    if (frequency == 1) {
                        freqMap.remove(prevEle); // Remove the element if its frequency becomes 0
                    }
            }

            System.out.println("Previous Element : " + prevEle + ", Freq : " + freqMap.get(prevEle) + ", Map size : " + freqMap.size() + ", Iterating Count : "+count);

            //check the size of elements in hashmap and increement count
            if(freqMap.size() >= k){
                count++;
            } 
           System.out.println("Current Element : "+ nums[i]+ ", Map size : " + freqMap.size() + ", Iterating Count : "+count);
        }
        return count;*/



        //Brute Force - TC: o(n2) - Time Limit Exceeded 
       /* int arrSize = nums.length;
        Map<Integer, Integer> freqMap;
        int count = 0;

        for(int i=0; i<arrSize; i++){
             freqMap = new HashMap<>();

             //check all subarrays keeping each element as start
             for(int j=i; j<arrSize; j++){
                int currElement = nums[j];
                if(!freqMap.containsKey(currElement)){
                    freqMap.put(currElement, 1);
                }else{
                    freqMap.put(currElement, freqMap.getOrDefault(currElement, 0) + 1);
                }
                
                if(freqMap.size()==k){
                    count++;
                }else if(freqMap.size() > k){
                    break;
                }
             }     
        }

        return count;
        */

        //Optimised Solution , TC : O(n)
        // Find the subarrays with at most k distinct integers as while finding subarrays with exactly k distinct integers using 2 pointers and sliding window will lead to 
        // missing some  subarrays to not being counted. 
        // Ref Link : https://www.youtube.com/watch?v=7wYGbV_LsX4
 
        int count1 = getSubarraysWithAtmostKDistinctIntegers(nums, k);
        int count2 = getSubarraysWithAtmostKDistinctIntegers(nums, k-1);

        return count1 - count2;
    }


    // we have to do in O(n) so we have to iterate once and use sliding window with 2 pointers
    public int getSubarraysWithAtmostKDistinctIntegers(int[] nums, int k){
        int l = 0;
        int r = 0;
        int count = 0;

        Map<Integer, Integer> freqMap = new HashMap<>();
        int arrSize = nums.length;

        //we have to take r till the end
        while(r < arrSize){

            int currElement = nums[r];

            //update the frequency of current element in the hashmap
            freqMap.put(currElement, freqMap.getOrDefault(currElement, 0) + 1);
            
            //check the size of hashmap and update the count accordingly
                while(freqMap.size() > k)
            {
                    //shrink the window since it has more number of elements in hashmap than expected
                    int leftElement = nums[l];
                    freqMap.put(leftElement, freqMap.getOrDefault(leftElement, 0) - 1);
                    if(freqMap.get(leftElement) == 0)
                    {
                        freqMap.remove(leftElement);
                    }
                    l = l + 1;
            }

            count += r - l + 1; 
            r += 1;
        }

        return count;
    }
}