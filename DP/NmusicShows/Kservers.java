// Problem 2:
// Given a list of n servers, with the computing power of ith server at powers[i]. A client wants to buy some K servers out of these n servers.
// The condition is that when these K servers are rearranged, the absolute difference between the computing powers of two adjacent servers should be less then or equal to 1.
// Also, these servers will form a circular network. So the first and last servers will also be considered adjacent.
// Find the maximum number of servers K, which the client can buy.
// Ex:
// powers = {4,3,5,1,2,2,1}

// Output: 5

import java.util.*;



public class Kservers {
    public static void main(String[] args) {
        int []powers = {8,2,4,7};
        
            Arrays.sort(powers);

            // 1, 1, 2, 2, 3, 4, 5

            int n=powers.length;
            int start=0;
            int end = 0;
            int k = 1;

            List<Integer> karr = new ArrayList<>();

            while(end<n){
                if(Math.abs(powers[end]-powers[start])<=1)
                {
                    int WindowSize = end-start+1;
                    k = Math.max(k,WindowSize);
                    end++;

                }else{
                    start++;
                }
            }
            System.out.println(k);
        
    }
}
