import java.util.HashMap;
import java.util.Stack;

class Solution {
     public static int removeDuplicates(int[] nums) 
    {
        int k=1;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] != nums[k])
            {
               nums[k++] = nums[i];
            }
        }
        for(int a:nums)
        {
            System.out.print(a);
        }
        return nums.length-k;
        
    }
    

    public static void main(String[] args) {
            System.out.println(removeDuplicates(new int[]{1,1,2}));
    }
    
}