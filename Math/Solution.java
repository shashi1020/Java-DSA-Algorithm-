/*100649. Minimum Swaps to Sort by Digit Sum
User Accepted:5847
User Tried:7649
Total Accepted:6118
Total Submissions:11752
Difficulty:Medium
You are given an array nums of distinct positive integers. You need to sort the array in increasing order based on the sum of the digits of each number. If two numbers have the same digit sum, the smaller number appears first in the sorted order.

Return the minimum number of swaps required to rearrange nums into this sorted order.

A swap is defined as exchanging the values at two distinct positions in the array. */

import java.util.*;
class Solution {

    static class pair{
        int idx;
        int d_sum;
        int val;
        pair(int idx, int val){
            this.idx = idx;
            this.val = val;
            this.d_sum = CalculateDigitSum(val);
        }
    }

    public static int minSwaps(int[] nums) {
        List<pair> list = new ArrayList<>();
        for(int i=0; i<nums.length;i++)
        {
            list.add(new pair(i,nums[i]));
        }

        list.sort((a,b)->{
            if(a.d_sum != b.d_sum)
            {
                return Integer.compare(a.d_sum,b.d_sum);
            }else{
                return Integer.compare(a.val,b.val);
            }
        });

        boolean []vis = new boolean[nums.length];
        int swaps=0;

        for(int i=0; i<nums.length; i++)
        {
            if(vis[i] || list.get(i).idx == i) {
                continue;
            }
            int cycle = 0;
            int j=i;

            
            while(!vis[j])
            {
                vis[j] = true;
                j = list.get(j).idx;
                cycle++;
            }
            if(cycle>1)
            {
                swaps += cycle-1;
            }
        }
       return swaps;
    }
    public static int CalculateDigitSum(int num){
        int sum=0;
        while(num>0)
        {
             sum += num%10;
             num /=10;

        }
        return sum;
    }


    public static int smallestIndex(int[] nums) {
        
        for(int i=0; i<nums.length; i++)
        {
           
            
            
            int num = Math.abs(nums[i]);
            int sum = 0;
            while(num>0)
            {
                int digit = num%10;
                sum =sum + digit;
                num /=10;
            } 

            if(sum==i)
            {
                return i;
            }
              
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {18,43,34,16};
        // System.out.println(smallestIndex(nums));

        System.out.println(minSwaps(nums));

    }
}