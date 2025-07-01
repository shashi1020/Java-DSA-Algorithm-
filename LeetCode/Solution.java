public class Solution {
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxConsecutiveOnes = 0;

        for (int right = 0; right < nums.length; right++) 
        {
            if (nums[right] == 0) {
                zeroCount++;
            }

            
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

           
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
        }

        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println("Maximum consecutive ones after flipping at most " + k + " zeros: " + longestOnes(nums, k));
    }
}
