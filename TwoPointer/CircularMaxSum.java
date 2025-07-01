public class CircularMaxSum {
    public static int maxSubarraySumCircular(int[] nums) {
        int kadanes_sum = Integer.MIN_VALUE;
        int currSum = 0;
        int total_sum = 0;
        for(int num : nums)
        {
            currSum += num;
            kadanes_sum = Math.max(currSum,kadanes_sum);
            if(currSum < 0)
            {
                currSum = 0;
            }
            total_sum += num; 
        }

        int minSum = Integer.MAX_VALUE;
        currSum = 0;
        for(int num:nums)
        {
          currSum = currSum + num;
          minSum = Math.min(currSum,minSum);
          if(currSum>0)
          {
            currSum=0;
          }
        }
       
        if(kadanes_sum<0)
        {
            return kadanes_sum;
        }
        int cSum = total_sum -minSum;
        
        return Math.max(kadanes_sum,cSum);
    }
    public static void main(String[] args) {
        int []nums = {5,-3,5};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
