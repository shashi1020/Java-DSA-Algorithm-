public class maximumsubarray {
    public static double findMaxAverage(int[] nums, int k) {
        double sum;
        double avg = Integer.MIN_VALUE;
        double curravg;
        for(int i = 0; i < nums.length-(k-1); i++)
        {   
            sum=0;
            for(int j = i; j < k+i; j++)
            {
                sum = sum + nums[j];
                
            }
            System.out.println(sum);
            curravg = sum/k;
            System.out.println(curravg);
            if(curravg < 0 && avg==0)
            {
                return curravg;
            }
            avg = Math.max(avg, curravg);

                     
        }
        return avg;
        
    }
    

    public static void main(String[] args) {
        int nums[] = {-1}; 
        int k=1;
        System.out.println(findMaxAverage(nums,k));
        
    
    }
}
