import java.util.*;

class ClosestSum{
 public static int threeSumClosest(int[] nums, int target) {
        // start with any valid triplet

        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[2];

        // iterate through nums
        for(int i=0; i < nums.length-2; i++)
        {
            int left = i+1;
            int right=nums.length-1;

            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
               
                if(sum==target){
                    return sum;
                }

                if(Math.abs(target-sum) < Math.abs(target - closestSum))
                {
                    closestSum = sum;
                }
                
                if(sum<target)
                {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int nums[] = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(threeSumClosest(nums,-2));
    }
}