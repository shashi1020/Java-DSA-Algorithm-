import java.util.*;
public class pairsum {
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int count=0;
        while(i<j)
        {
            if(nums[i] + nums[j] == k)
            {
                count++;
                i++;
                j--;
            }
            else if(nums[i] + nums[j] > k)
            {
                j--;
            }
            else{
                i++;
            }
            
        }
        return count;
       
        
    }
    public static void main(String[] args) {
    int arr[] = {1,2,3,4};
    System.out.println(maxOperations(arr, 5)); 
    }
}
