import java.util.*;
public class Sum4{
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<4)
        {
            return result;
        }
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++)
        {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<nums.length-1; j++)
            {
                
                int left = j+1;
                int right = nums.length-1;
                while(left<right)
                {
                    int sum = nums[i] + nums[j] + nums[left]+nums[right];
                    if(sum==target)
                    {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                    }
                    
                   
                    if(sum<target)
                    {
                        left++;
                    }else{
                        right--;
                    }
                }
            }

        }
        return result;
        
    }
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{0,0,-1,-2,1,2},0));
    }
}
