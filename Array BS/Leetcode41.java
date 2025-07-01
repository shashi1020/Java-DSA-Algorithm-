import java.util.*;

public class Leetcode41 {

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
        {
            if(isDuplicate(nums, i+1, nums.length-1,nums[i]))
            {
                return nums[i];
            }
        }

        return nums.length+1;

    }


    public static boolean isDuplicate(int[] nums, int start, int end, int target)
    {   
        while(start<=end)
        {
            int mid = (start+end)/2;

            if(nums[mid] == target) {
                return true;
            }else if(target>nums[mid])
            {
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
        
    }


     public static int firstMissingPositive(int[] nums) {
            Arrays.sort(nums);
            for(int i=1; i<nums.length; i++)
            {
                if(nums[i]!=i)
                {
                    return i;
                }
            }
            return nums.length;
    }

    public static void main(String[] args) {
        int nums[] = {7,8,9,11,12,11};
        System.out.println(findDuplicate(nums));

    }
}
