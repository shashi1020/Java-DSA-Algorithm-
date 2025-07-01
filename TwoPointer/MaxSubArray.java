// kadanes algo

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        
        if(nums == null || nums.length==0)
        {
            return 0;
        }   
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int num:nums)
        {   
            currSum = currSum + num;
            maxSum = Math.max(currSum,maxSum);
            if(currSum<0)
            {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }
}
