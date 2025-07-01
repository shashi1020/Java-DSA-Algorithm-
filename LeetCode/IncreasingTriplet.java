public class IncreasingTriplet {

    public static boolean increasingTriplet(int[] nums)
    {
        int min1= Integer.MAX_VALUE;
        int min2= Integer.MAX_VALUE;

        for(int num : nums)
        {
            if(num <= min1)
            {
                min1 = num;
            }
            else if(num <= min2)
            {
                min2 = num;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int []arr = {20, 100, 10, 12, 5, 13};
        System.out.println(increasingTriplet(arr));
    }
}
