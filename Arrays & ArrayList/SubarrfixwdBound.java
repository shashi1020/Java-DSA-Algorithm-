import java.util.ArrayList;
import java.util.List;
public class SubarrfixwdBound {
    public static long countSubarrays(int[] nums, int minK, int maxK) {

        int lastminK = -1;
        int lastmaxK = -1;
        int lastinvalidelement = -1;
        int count = 0;
        
        for(int i=0; i<nums.length; i++)
        {
                if(nums[i] == minK) lastminK = i;
                if(nums[i] == maxK) lastmaxK = i;
                if(nums[i] < minK || nums[i] > maxK) lastinvalidelement = i;

                count += Math.max(0, Math.min(lastminK,lastmaxK)-lastinvalidelement);
            
        }

        System.out.println(count);
        return 0;
    }

        public static void main(String[] args) {
            int nums[] = {1,3,5,2,7,5};
            int minK = 1;
            int maxK = 1;
            System.out.println(countSubarrays(nums, minK, maxK));

        }
}
