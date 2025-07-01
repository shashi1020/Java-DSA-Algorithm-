import java.util.Arrays;
import java.util.Stack;

class LargestRectangle{

// Brute Force Approach

    public static int largestRectangleArea(int[] heights) {
        
        int maxHeight = 0;

        for(int i=0; i<heights.length; i++)
        {
            int height = heights[i];

            int left = i;
            while(left>0 && heights[left-1] >= height)
            {
                left--;
            }
            int right = i;
            while(right < (heights.length-1) && heights[right+1] >= height)
            {
                right++;
            }

            int width = right-left+1;
    
            maxHeight = Math.max(maxHeight, height*width);
        }
            
        
        return maxHeight;

    }

     public static int largestRectangleAreaStack(int[] heights) {


        return 0;
     }
    
    public static void main(String []args){
        int heights[] = {3,6,5,7,4,8,1,0};

        System.out.println(largestRectangleAreaII(heights));  
       
        
 }


//  2nd approach usiing monotonic stack
    public static int[] findPreviouselement(int []heights)
    {
        Stack<Integer> stack = new Stack<>();

        int[] previous = new int[heights.length];

        for(int i =0; i<heights.length; i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
            {
               stack.pop();
            }

            previous[i] = stack.isEmpty() ? -1 : stack.peek();

            // push current element
            stack.push(i);
        }
        return previous;
    }

    public static int[] nextSmallerElement(int []heights)
    {

        Stack<Integer> stack = new Stack<>();

        int []nextSmaller = new int[heights.length];

        for(int i=heights.length-1; i>=0; i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }

            nextSmaller[i] = stack.isEmpty()?heights.length:stack.peek();


            stack.push(i);

        }
        return nextSmaller;
    }

    public static int largestRectangleAreaII(int[] heights) {
        int[] pse = findPreviouselement(heights);
        int[] nse = nextSmallerElement(heights);

        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++)
        {
            int area = heights[i] * (nse[i] - pse[i] -1);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}